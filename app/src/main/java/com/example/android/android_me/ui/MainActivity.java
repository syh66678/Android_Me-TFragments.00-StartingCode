package com.example.android.android_me.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;


/**
 * Created by Administrator on 2017/9/11.
 */

public class MainActivity extends AppCompatActivity implements MasterListFragment.OnImageClickListener{

    private int headIndex;
    private int bodyIndex;
    private int legIndex;

    private boolean mTwoPane;

    @Override
    public void startActivityAttrs() {
        final Intent intent=new Intent(this, AndroidMeActivity.class);
        Bundle bundle=  new Bundle();
        bundle.putInt("headIndex",headIndex);
        bundle.putInt("bodyIndex",bodyIndex);
        bundle.putInt("legIndex",legIndex);

        intent.putExtras(bundle);
        startActivity(intent);
    }


    @Override
    public void onImageSelected(int position) {

        Toast.makeText(this,"Position clicked ="+position,Toast.LENGTH_SHORT).show();

        int bodyPartNumber = position /12;

        int listIndex=position - 12 * bodyPartNumber;
        if (mTwoPane){
            BodyPartFragment newFragment = new BodyPartFragment();
            switch (bodyPartNumber){
                case 0:
                    newFragment.setmImageIds(AndroidImageAssets.getHeads());
                    newFragment.setmListIndex(listIndex);

                    getSupportFragmentManager().beginTransaction().replace(R.id.head_container,newFragment).commit();
                    break;
                case 1:
                    newFragment.setmImageIds(AndroidImageAssets.getBodies());
                    newFragment.setmListIndex(listIndex);

                    getSupportFragmentManager().beginTransaction().replace(R.id.body_container,newFragment).commit();
                    break;
                case 2:
                    newFragment.setmImageIds(AndroidImageAssets.getLegs());
                    newFragment.setmListIndex(listIndex);

                    getSupportFragmentManager().beginTransaction().replace(R.id.leg_container,newFragment).commit();
                    break;
            }
        }else {
            switch (bodyPartNumber) {
                case 0:
                    headIndex = listIndex;
                    break;
                case 1:
                    bodyIndex = listIndex;
                    break;
                case 2:
                    legIndex = listIndex;
                    break;
                default:
                    break;
            }
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        View android_me=findViewById(R.id.android_me_linear_layout_bug);
        boolean temp=android_me!=null ? true : false;
        MasterListFragment masterListFragment = new MasterListFragment(temp );
        FragmentManager fragmentManager=getSupportFragmentManager();

        /*if (savedInstanceState== null)
        fragmentManager.beginTransaction().add(R.id.master_list_fragment, masterListFragment).commit();
        //setContentView(R.layout.activity_android_me);
        */



        //View view=findViewById(R.id.master_list_fragment);

        if ( android_me !=null ){
            mTwoPane=true;
            //Button nextButton = (Button)findViewById(R.id.next_button);



            if (savedInstanceState == null) {
                //Intent intent = this.getIntent();
                //Bundle bundle=intent.getExtras();
                int head=0;
                int body=0;
                int leg=0;

                //HeadPartFragment headFragment = new HeadPartFragment();
                BodyPartFragment headFragment = new BodyPartFragment();
                headFragment.setmImageIds(AndroidImageAssets.getHeads());
                headFragment.setmListIndex(head);

                BodyPartFragment bodyPartFragment = new BodyPartFragment();
                bodyPartFragment.setmImageIds(AndroidImageAssets.getBodies());
                bodyPartFragment.setmListIndex(body);

                //LegPartFragment legPartFragment = new LegPartFragment();
                BodyPartFragment legPartFragment = new BodyPartFragment();
                legPartFragment.setmImageIds(AndroidImageAssets.getLegs());
                legPartFragment.setmListIndex(leg);

                //FragmentManager fragmentManager = getSupportFragmentManager();

                fragmentManager.beginTransaction().add(R.id.master_list_fragment,masterListFragment).add(R.id.head_container, headFragment).add(R.id.body_container, bodyPartFragment).add(R.id.leg_container, legPartFragment).commit();
            }
        }else {
            mTwoPane=false;

            fragmentManager.beginTransaction().add(R.id.master_list_fragment, masterListFragment).commit();

        }








    }
}
