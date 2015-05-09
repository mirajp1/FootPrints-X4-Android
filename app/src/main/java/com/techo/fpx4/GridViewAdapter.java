package com.techo.fpx4;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.support.v4.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class GridViewAdapter extends BaseAdapter {

    private ArrayList<Integer> buttonNameList;        //List of text ids for names of each button present in strings.xml
    private ArrayList<Integer> buttonDeptList;        //List of text ids for departments of each button present in strings.xml
    private ArrayList<Integer> buttonIconList;        //List of image ids for each button present in the drawables folder.
    private ArrayList<String> etc;                //dummy string to implemnet a pure virtual function.
    private Activity activity;
    int x;
    private LruCache<String, Bitmap> mMemoryCache;


    //public constructor

    public GridViewAdapter(Activity activity, ArrayList<Integer> buttonNameList, ArrayList<Integer> buttonIconList, ArrayList<Integer> buttonDeptList) {
        super();
        this.buttonNameList = buttonNameList;
        this.buttonIconList = buttonIconList;
        this.activity = activity;
        this.buttonDeptList = buttonDeptList;


        final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);

        // Use 1/8th of the available memory for this memory cache.
        final int cacheSize = maxMemory / 8;

        mMemoryCache = new LruCache<String, Bitmap>(cacheSize) {

            protected int sizeOf(String key, Bitmap bitmap) {
                // The cache size will be measured in bytes rather than number
                // of items.
                return bitmap.getRowBytes() * bitmap.getHeight();
            }

        };

    }
    
    /*public GridViewAdapter(Activity activity,ArrayList<Integer> buttonNameList, ArrayList<Integer> buttonIconList, ArrayList<Integer> buttonDeptList, ArrayList<Integer> buttonIconList1) {
        super();
        this.buttonNameList = buttonNameList;
        this.buttonIconList = buttonIconList;
        this.activity = activity;
        this.buttonDeptList=buttonDeptList;
        this.buttonIconList1=buttonIconList1;
    }*/


    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return buttonNameList.size();
    }

    @Override
    public String getItem(int position) {
        // TODO Auto-generated method stub
        return etc.get(position);
    }


    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    public static class ViewHolder {
        public ImageView viewHolderIcon;
        public TextView viewHolderName;
        public TextView viewHolderDept;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        final ViewHolder view;
        LayoutInflater inflator = activity.getLayoutInflater();

        if (convertView == null) {
            view = new ViewHolder();
            convertView = inflator.inflate(R.layout.layout_gridview_item, null);

            view.viewHolderName = (TextView) convertView.findViewById(R.id.buttonName);        //inflate the name textview
            view.viewHolderIcon = (ImageView) convertView.findViewById(R.id.buttonIcon);    //inlfate the icon imageview


            if (buttonDeptList.get(position) != 0) {

                view.viewHolderDept = (TextView) convertView.findViewById(R.id.buttonDept);    //set the department textview if the first value in the buttonDeptList is not zero.
            } else {

                convertView.findViewById(R.id.buttonDept).setVisibility(View.GONE);            //delete if zero
            }

            convertView.setTag(view);
        } else {
            view = (ViewHolder) convertView.getTag();
        }

        loadBitmap(buttonIconList.get(position), view.viewHolderIcon);
        //set the values in textviews and imageviews

        view.viewHolderName.setText(buttonNameList.get(position));
        //view.viewHolderIcon.setImageResource(buttonIconList.get(position));


        if (buttonDeptList.get(0) != 0) {

            view.viewHolderDept.setText(buttonDeptList.get(position));
        }
        return convertView;
    }


    public void loadBitmap(int resId, ImageView imageView) {
        if (cancelPotentialWork(resId, imageView)) {
            final BitmapWorkerTask task = new BitmapWorkerTask(imageView);
            //imageView.setBackgroundResource(R.drawable.empty_photo);
            task.execute(resId);
        }
    }

    static class AsyncDrawable extends BitmapDrawable {
        private final WeakReference<BitmapWorkerTask> bitmapWorkerTaskReference;

        public AsyncDrawable(Resources res, Bitmap bitmap,
                             BitmapWorkerTask bitmapWorkerTask) {
            super(res, bitmap);
            bitmapWorkerTaskReference = new WeakReference<BitmapWorkerTask>(
                    bitmapWorkerTask);
        }

        public BitmapWorkerTask getBitmapWorkerTask() {
            return bitmapWorkerTaskReference.get();
        }
    }

    public static boolean cancelPotentialWork(int data, ImageView imageView) {
        final BitmapWorkerTask bitmapWorkerTask = getBitmapWorkerTask(imageView);

        if (bitmapWorkerTask != null) {
            final int bitmapData = bitmapWorkerTask.data;
            if (bitmapData != data) {
                // Cancel previous task
                bitmapWorkerTask.cancel(true);
            } else {
                // The same work is already in progress
                return false;
            }
        }
        // No task associated with the ImageView, or an existing task was
        // cancelled
        return true;
    }

    private static BitmapWorkerTask getBitmapWorkerTask(ImageView imageView) {
        if (imageView != null) {
            final Drawable drawable = imageView.getDrawable();
            if (drawable instanceof AsyncDrawable) {
                final AsyncDrawable asyncDrawable = (AsyncDrawable) drawable;
                return asyncDrawable.getBitmapWorkerTask();
            }
        }
        return null;
    }

    public void addBitmapToMemoryCache(String key, Bitmap bitmap) {
        if (getBitmapFromMemCache(key) == null) {
            mMemoryCache.put(key, bitmap);
        }
    }

    public Bitmap getBitmapFromMemCache(String key) {
        return (Bitmap) mMemoryCache.get(key);
    }

    class BitmapWorkerTask extends AsyncTask<Integer, Void, Bitmap> {
        public int data = 0;
        private final WeakReference<ImageView> imageViewReference;

        public BitmapWorkerTask(ImageView imageView) {
            // Use a WeakReference to ensure the ImageView can be garbage
            // collected
            imageViewReference = new WeakReference<ImageView>(imageView);
        }

        // Decode image in background.
        @Override
        protected Bitmap doInBackground(Integer... params) {
            data = params[0];
            final Bitmap bitmap = decodeSampledBitmapFromResource(
                    activity.getResources(), data, 100, 100);
            addBitmapToMemoryCache(String.valueOf(params[0]), bitmap);
            return bitmap;
        }

        // Once complete, see if ImageView is still around and set bitmap.
        @Override
        protected void onPostExecute(Bitmap bitmap) {
            if (imageViewReference != null && bitmap != null) {
                final ImageView imageView = imageViewReference.get();
                if (imageView != null) {
                    imageView.setImageBitmap(bitmap);
                }
            }
        }
    }

    public static Bitmap decodeSampledBitmapFromResource(Resources res,
                                                         int resId, int reqWidth, int reqHeight) {

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth,
                reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }

    public static int calculateInSampleSize(BitmapFactory.Options options,
                                            int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            // Calculate ratios of height and width to requested height and
            // width
            final int heightRatio = Math.round((float) height
                    / (float) reqHeight);
            final int widthRatio = Math.round((float) width / (float) reqWidth);

            // Choose the smallest ratio as inSampleSize value, this will
            // guarantee
            // a final image with both dimensions larger than or equal to the
            // requested height and width.
            inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
        }

        return inSampleSize;
    }

}

