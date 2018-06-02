package com.clarksworld.clarkson.testdraw1;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.clarksworld.clarkson.testdraw1.activities.ClaranceActivity;
import com.clarksworld.clarkson.testdraw1.activities.DecryptionActivity;
import com.clarksworld.clarkson.testdraw1.activities.EditProfileActivity;
import com.clarksworld.clarkson.testdraw1.activities.ExamPermitActivity;
import com.clarksworld.clarkson.testdraw1.activities.ExeatActivity;
import com.clarksworld.clarkson.testdraw1.activities.PayFeesActivity;
import com.clarksworld.clarkson.testdraw1.activities.SignUpActivity;
import com.google.firebase.auth.FirebaseAuth;

public class BaseActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    TextView name_tv, matric_tv, faculty_tv, department_tv, level_tv, email_tv, edit_tv;
    ImageView profileImage, cameraImage;



    Integer  SELECT_FILE = 0;
    static final int REQUEST_IMAGE_CAPTURE = 10;
    public static final int CAMERA_REQUEST_CODE = 8675309;
    private int STORAGE_PERMISSION_CODE = 1;


    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener authStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);


        name_tv = findViewById(R.id.profile_name_tv);
        matric_tv = findViewById(R.id.profile_matric_tv);
        faculty_tv = findViewById(R.id.profile_faculty_tv);
        department_tv = findViewById(R.id.profile_department_tv);
        level_tv = findViewById(R.id.profile_level_tv);
        email_tv = findViewById(R.id.profile_email_tv);
        profileImage = findViewById(R.id.profile_image);
        cameraImage = findViewById(R.id.camera_image);
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        cameraImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectPicture();
            }
        });

//        FloatingActionButton fab =  findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(BaseActivity.this, StudentInformationActivity.class);
//                startActivity(intent);
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer,
                toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        textviews();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
          signOut1();
        } else if (id == R.id.nav_gallery) {
            Intent intent = new Intent(BaseActivity.this, PayFeesActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_slideshow) {
            Intent intent = new Intent(BaseActivity.this, ClaranceActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_manage) {
            Intent intent =  new Intent(BaseActivity.this, ExeatActivity.class);
            startActivity(intent);





        } else if (id == R.id.nav_share) {
            Intent intent =  new Intent(BaseActivity.this, ExamPermitActivity.class);
            startActivity(intent);


        } else if (id == R.id.nav_send) {
            Intent intent =  new Intent(BaseActivity.this, DecryptionActivity.class);
            startActivity(intent);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void textviews(){
        name_tv = findViewById(R.id.profile_name_tv);
        matric_tv = findViewById(R.id.profile_matric_tv);
        faculty_tv = findViewById(R.id.profile_faculty_tv);
        department_tv = findViewById(R.id.profile_department_tv);
        level_tv = findViewById(R.id.profile_level_tv);
        email_tv = findViewById(R.id.profile_email_tv);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String matNumber = intent.getStringExtra("matNumber");
        String faculty = intent.getStringExtra("faculty");
        String department = intent.getStringExtra("department");
        String level = intent.getStringExtra("level");
        String email = intent.getStringExtra("email");

        name_tv.setText(name);
        matric_tv.setText(matNumber);
        faculty_tv.setText(faculty);
        department_tv.setText(department);
        level_tv.setText(level);
        email_tv.setText(email);


        edit_tv = findViewById(R.id.profile_edit_tv);
        edit_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BaseActivity.this, EditProfileActivity.class);
                startActivity(intent);
            }
        });
    }



    public void permissionRequest(){
        if (ContextCompat.checkSelfPermission(BaseActivity.this, android.Manifest.permission.READ_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_GRANTED) {
//                    Toast.makeText(GalleryActivity.this, "You have already granted this permission!",
            //                           Toast.LENGTH_SHORT).show();
            getPictureName();

        } else {
            requestStoragePermission();
        }
    }



    private void requestStoragePermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                android.Manifest.permission.READ_EXTERNAL_STORAGE)) {

            new android.app.AlertDialog.Builder(this)
                    .setTitle("Permission needed")
                    .setMessage("This permission is needed because of this and that")
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityCompat.requestPermissions(BaseActivity.this,
                                    new String[] {android.Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSION_CODE);
                        }
                    })
                    .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .create().show();

        } else {
            ActivityCompat.requestPermissions(this,
                    new String[] {android.Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSION_CODE);
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    public void camerasetup() {
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            dispatchTakePictureIntent();
        } else {

            String[] permissionRequest = {android.Manifest.permission.CAMERA};
            requestPermissions(permissionRequest, CAMERA_REQUEST_CODE);
        }
    }



    public void getPictureName() {

        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        startActivityForResult(intent.createChooser(intent, "select file"), SELECT_FILE);
    }
    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }



    private void selectPicture() {


        final CharSequence[] items = {"Camera", "Gallery", "Cancel"};
        AlertDialog.Builder builder = new AlertDialog.Builder(BaseActivity.this);
        builder.setTitle("select a profile picture");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (items[which].equals("Camera")) {
                    camerasetup();
                } else if (items[which].equals("Gallery")) {
                    getPictureName();
                } else if (items[which].equals("Cancel")) {
                    dialog.dismiss();

                }

            }
        });
        builder.show();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK){

            if (requestCode == REQUEST_IMAGE_CAPTURE){
                Bundle bundle = data.getExtras();
                final Bitmap bitmap = (Bitmap)bundle.get("data");
                profileImage.setImageBitmap(bitmap);
            } else  if (requestCode == SELECT_FILE){
                Uri selectImage = data.getData();
                profileImage.setImageURI(selectImage);
            }
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == CAMERA_REQUEST_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                dispatchTakePictureIntent();
            } else if (requestCode == STORAGE_PERMISSION_CODE)  {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                Toast.makeText(this, "Permission GRANTED", Toast.LENGTH_SHORT).show();
                    getPictureName();
                }

            }else {
                Toast.makeText(this, "needs permission for camera", Toast.LENGTH_SHORT).show();

            }
        }

    }



    private void signOut(){
        mAuth = FirebaseAuth.getInstance();
        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser()  == null);
                Intent intent = new Intent(BaseActivity.this, SignUpActivity.class);
                startActivity(intent);

            }
        };

        mAuth.signOut();


    }

    private void signOut1() {
        mAuth.signOut();
        Intent intent = new Intent(BaseActivity.this, SignUpActivity.class);
        startActivity(intent);


    }

}
