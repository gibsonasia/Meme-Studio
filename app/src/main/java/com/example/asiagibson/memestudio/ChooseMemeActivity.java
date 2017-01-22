package com.example.asiagibson.memestudio;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.asiagibson.memestudio.Activities.EnterTextActivity;

public class ChooseMemeActivity extends Activity implements View.OnClickListener {

    private static final String IMAGE_URI_KEY = "IMAGE_URI";
    private static final String BITMAP_WIDTH = "BITMAP_WIDTH";
    private static final String BITMAP_HEIGHT = "BITMAP_HEIGHT";
    private Uri pictureUri;
    private ImageView selectedPicture;
    private Button basicMemeButton;
    private Button otherMemeButton;
    private Button otherMemeButton2;
    private Button otherMemeButton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_meme);

        selectedPicture = (ImageView) findViewById(R.id.selected_picture_imageview1);

        basicMemeButton = (Button) findViewById(R.id.basic_meme);
        basicMemeButton.setOnClickListener(this);

        otherMemeButton = (Button) findViewById(R.id.other_meme);
        otherMemeButton.setOnClickListener(this);

        otherMemeButton2 = (Button) findViewById(R.id.other_meme2);
        otherMemeButton2.setOnClickListener(this);

        otherMemeButton3 = (Button) findViewById(R.id.other_meme3);
        otherMemeButton3.setOnClickListener(this);

        pictureUri = getIntent().getParcelableExtra(IMAGE_URI_KEY);

        int bitmapWidth = getIntent().getIntExtra(BITMAP_WIDTH, 100);
        int bitmapHeight = getIntent().getIntExtra(BITMAP_HEIGHT, 100);

        Bitmap selectedImageBitmap = BitmapResizer.ShrinkBitmap(pictureUri.toString(), bitmapWidth, bitmapHeight);
        selectedPicture.setImageBitmap(selectedImageBitmap);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.basic_meme:
                moveToNextScreen();
                break;

            case R.id.other_meme:
                Toast.makeText(this, "Some other meme", Toast.LENGTH_SHORT).show();
                break;

            case R.id.other_meme2:
                Toast.makeText(this, "Some other meme2", Toast.LENGTH_SHORT).show();
                break;

            case R.id.other_meme3:
                Toast.makeText(this, "Some other meme3", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void moveToNextScreen() {

        Intent nextScreenIntent = new Intent(this, EnterTextActivity.class);
        nextScreenIntent.putExtra(IMAGE_URI_KEY, TakePictureActivity.selectedPhotoPath);
        nextScreenIntent.putExtra(BITMAP_WIDTH, TakePictureActivity.takePictureImageView.getWidth());
        nextScreenIntent.putExtra(BITMAP_HEIGHT, TakePictureActivity.takePictureImageView.getHeight());

        startActivity(nextScreenIntent);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            super.onRestoreInstanceState(savedInstanceState);
        }
    }
}
