package com.example.asiagibson.memestudio;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TakePictureActivity extends Activity implements View.OnClickListener {

    private Boolean pictureTaken = false;
    private static final int TAKE_PHOTO_REQUEST_CODE = 1;
    private static final String APP_PICTURE_DIRECTORY = "/Memeify";
    private static final String FILE_SUFFIX_JPG = ".jpg";
    public static Uri selectedPhotoPath;
    public static ImageView takePictureImageView;
    private ImageView pictureGalleryIv;
    private static final String IMAGE_URI_KEY = "IMAGE_URI";
    private static final String BITMAP_WIDTH = "BITMAP_WIDTH";
    private static final String BITMAP_HEIGHT = "BITMAP_HEIGHT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_picture);

        permission();

        takePictureImageView = (ImageView) findViewById(R.id.picture_imageview);
        takePictureImageView.setOnClickListener(this);

        pictureGalleryIv = (ImageView) findViewById(R.id.picture_imageview2);
        pictureGalleryIv.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.picture_imageview:
                takePictureWithCamera();
                break;

            case R.id.picture_imageview2:
                Toast.makeText(this, "Gallery Should Open", Toast.LENGTH_SHORT).show();
                break;

            default:
                break;
        }
    }

    private void takePictureWithCamera() {

        // create intent to capture image from camera
        Intent captureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        File photoFile = createImageFile();
        selectedPhotoPath = Uri.parse(photoFile.getAbsolutePath());

        captureIntent.putExtra(android.provider.MediaStore.EXTRA_OUTPUT, Uri.fromFile(photoFile));
        startActivityForResult(captureIntent, TAKE_PHOTO_REQUEST_CODE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == TAKE_PHOTO_REQUEST_CODE && resultCode == RESULT_OK) {
            setImageViewWithImage();
        }
    }

    private void setImageViewWithImage() {
        Bitmap pictureBitmap = BitmapResizer.ShrinkBitmap(selectedPhotoPath.toString(),
                takePictureImageView.getWidth(),
                takePictureImageView.getHeight());
        takePictureImageView.setImageBitmap(pictureBitmap);
        pictureTaken = true;

        moveToNextScreen();
    }

    private File createImageFile() {

        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";

        File storageDir = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES + APP_PICTURE_DIRECTORY);
        storageDir.mkdirs();

        File imageFile = null;

        try {
            imageFile = File.createTempFile(
                    imageFileName,  /* prefix */
                    FILE_SUFFIX_JPG,         /* suffix */
                    storageDir      /* directory */
            );
        } catch (IOException e) {
            e.printStackTrace();
        }

        return imageFile;
    }

    private void moveToNextScreen() {

        if (pictureTaken) {
            Intent nextScreenIntent = new Intent(this, ChooseMemeActivity.class);
            nextScreenIntent.putExtra(IMAGE_URI_KEY, selectedPhotoPath);
            nextScreenIntent.putExtra(BITMAP_WIDTH, takePictureImageView.getWidth());
            nextScreenIntent.putExtra(BITMAP_HEIGHT, takePictureImageView.getHeight());

            startActivity(nextScreenIntent);
        } else {
            Toast.makeText(this, R.string.select_a_picture, Toast.LENGTH_SHORT).show();
        }

    }

    public void permission() {

//        if ((ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) || (ActivityCompat.checkSelfPermission(this, Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED)) {
//
//            ActivityCompat.requestPermissions(this,
//                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},   //request specific permission from user
//                    10);
//            ActivityCompat.requestPermissions(this,
//                    new String[]{Manifest.permission.INTERNET},   //request specific permission from user
//                    10);
//
//            return;
//        }

    }
}
