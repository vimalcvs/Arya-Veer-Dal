package com.bindesh.aryaveerdalchattisgarh;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.firebase.ui.auth.AuthUI;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.messaging.FirebaseMessaging;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,FirebaseAuth.AuthStateListener {

    private static final String TAG = "MainActivity";
    public CardView cardView1, cardView2, cardView3, cardView4, cardView5, cardView6, cardView7, cardView8 ,cardView9,cardView10;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//card view initilazation
      

        cardView1 = (CardView) findViewById(R.id.card1);
        cardView2 = (CardView) findViewById(R.id.card2);
        cardView3 = (CardView) findViewById(R.id.card3);
        cardView4 = (CardView) findViewById(R.id.card4);
        cardView5 = (CardView) findViewById(R.id.card5);
        cardView6 = (CardView) findViewById(R.id.card6);
        cardView7 = (CardView) findViewById(R.id.card7);
        cardView8 = (CardView) findViewById(R.id.card8);
        cardView9 = (CardView) findViewById(R.id.card9);
        cardView10 = (CardView) findViewById(R.id.card10);

        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, Parichaya.class);
                startActivity(myIntent);


            }
        });
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, Pathyakaram.class);
                startActivity(myIntent);
            }
        });


        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, Vyayamsangeet.class);
                startActivity(myIntent);


            }
        });
        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, Sangeet.class);
                Toast.makeText(MainActivity.this, "कार्य प्रगति पर है इस पेज का अपडेट जल्द ही आएगा ", Toast.LENGTH_SHORT).show();

                startActivity(myIntent);
            }
        });

        cardView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, Dastavez.class);
                Toast.makeText(MainActivity.this, "कार्य प्रगति पर है इस पेज का अपडेट जल्द ही आएगा ", Toast.LENGTH_SHORT).show();

                startActivity(myIntent);
            }
        });

        cardView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, Mantra.class);
                startActivity(myIntent);
            }
        });
        cardView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, Arya_veer_dal.class);
                Toast.makeText(MainActivity.this, "कार्य प्रगति पर है इस पेज का अपडेट जल्द ही आएगा ", Toast.LENGTH_SHORT).show();

                startActivity(myIntent);


            }
        });
        cardView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, Arya_veerangna_dal.class);
                Toast.makeText(MainActivity.this, "कार्य प्रगति पर है इस पेज का अपडेट जल्द ही आएगा ", Toast.LENGTH_SHORT).show();

                startActivity(myIntent);


            }
        });
        cardView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, Contact_Us.class);
                startActivity(myIntent);


            }
        });
        cardView10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, Naya_Sanskaran.class);
                startActivity(myIntent);


            }
        });


        //drawer layout
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);




        if(

                getIntent().

                        getExtras() !=null)

        {

            for (String key : getIntent().getExtras().keySet()) {
                String value = getIntent().getExtras().getString(key);

                if (key.equals("Another") && value.equals("True")) {
                    Intent intent = new Intent(this, Notification.class);
                    intent.putExtra("value", value);
                    startActivity(intent);
                    finish();
                }

            }
        }

        subscribeToPushService();

    }




//Notification
    private void subscribeToPushService() {
        FirebaseMessaging.getInstance().subscribeToTopic("news");

        // Log.d("AndroidBash", "Subscribed");
        //  Toast.makeText(MainActivity.this, "Subscribed", Toast.LENGTH_SHORT).show();

     //   String token = FirebaseInstanceId.getInstance().getToken();

        // Log and toast
        //   Log.d("AndroidBash", token);
        // Toast.makeText(MainActivity.this, token, Toast.LENGTH_SHORT).show();

    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
      //  AuthUI.getInstance().signOut(this);
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
        if (id == R.id.action_notification) {
            Intent myIntent = new Intent(MainActivity.this, Notification.class);
            startActivity(myIntent);
        }

        if (id == R.id.action_Contact_Us) {
            Intent myIntent = new Intent(MainActivity.this, Contact_Us.class);
            startActivity(myIntent);
        }
        if (id == R.id.action_developer) {
            Intent myIntent = new Intent(MainActivity.this, Developer_profile.class);
            startActivity(myIntent);
        }

        if (id == R.id.action_Exit) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle(R.string.app_name);
            builder.setIcon(R.mipmap.ic_launcher);
            builder.setMessage("Do you want to exit?")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            finish();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
            AuthUI.getInstance().signOut(this);

            AlertDialog alert = builder.create();
            alert.show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void startLoginActivity() {
        Intent intent = new Intent(this, Login_RegisterActivity.class);
        startActivity(intent);
        finish();
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_aboutme) {
            Intent myIntent = new Intent(MainActivity.this, Aboutme.class);
            startActivity(myIntent);


            // Handle the camera action
        } else if (id == R.id.nav_home) {
            Intent myIntent = new Intent(MainActivity.this, MainActivity.class);
            startActivity(myIntent);



        }else if (id==R.id.nav_arya_samaj){
            Intent myIntent = new Intent(MainActivity.this, Arya_Samaj.class);
            startActivity(myIntent);

        }
        else if (id == R.id.nav_slideshow) {
            Intent myIntent = new Intent(MainActivity.this, Drawer_Karyakarni.class);
            startActivity(myIntent);
        } else if (id == R.id.nav_manage) {
            Toast.makeText(MainActivity.this, "इस पेज का अपडेट जल्द ही आएगा", Toast.LENGTH_SHORT).show();

        }  else if (id == R.id.nav_share) {
            String share = "  Arya Veer Dal "+ "Download Sarvadeshik Arya veer dal mobile application for to know all about arya veer dal.\\n\" +\n";
            String shareBody = share + "\nhttps://play.google.com/store/apps/developer?id="+ this.getPackageName();
            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Arya Veer Dal");
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(sharingIntent, "Share via"));
            return true;

        } else if (id == R.id.nav_send) {
            Intent Email = new Intent(Intent.ACTION_SEND);
            Email.setType("text/email");
            Email.putExtra(Intent.EXTRA_EMAIL, new String[] { "sarvadeshikaryaveerdal@gmail.com" });
            Email.putExtra(Intent.EXTRA_SUBJECT, "Feedback");
            Email.putExtra(Intent.EXTRA_TEXT, "Dear ...," + "");
            startActivity(Intent.createChooser(Email, "Send Feedback Email:"));

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseAuth.getInstance().addAuthStateListener(this);
    }


    @Override
    public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
        if (firebaseAuth.getCurrentUser() == null) {
            startLoginActivity();
            return;
        }
    }

    }

