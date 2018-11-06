package com.example.shuangxi.app3;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.example.shuangxi.app3.TitlesFragment.ListSelectionListener;


/*  SFActivity show the view of interest points titles     */
public class SFActivity extends AppCompatActivity implements ListSelectionListener {

    private final DetailsFragment mQuoteFragment = new DetailsFragment();
    private FragmentManager mFragmentManager;
    private FrameLayout mTitleFrameLayout, mQuotesFrameLayout;

    private static final int MATCH_PARENT = LinearLayout.LayoutParams.MATCH_PARENT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher_round);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.activity_fragment_layout);


        // Get references to the TitleFragment and to the QuotesFragment
        mTitleFrameLayout = (FrameLayout) findViewById(R.id.titles);
        mQuotesFrameLayout = (FrameLayout) findViewById(R.id.details);


        // Get a reference to the FragmentManager
        mFragmentManager = getFragmentManager();

        // Start a new FragmentTransaction
        FragmentTransaction fragmentTransaction = mFragmentManager
                .beginTransaction();

        // Add the TitleFragment to the layout
        // UB: 10/2/2016 Changed add() to replace() to avoid overlapping fragments
        fragmentTransaction.replace(R.id.titles,
                new TitlesFragment());

        // Commit the FragmentTransaction
        fragmentTransaction.commit();

        // Add a OnBackStackChangedListener to reset the layout when the back stack changes
        mFragmentManager
                .addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
                    public void onBackStackChanged() {
                        setLayout();
                    }
                });
    }

    private void setLayout() {

        // Determine whether the QuoteFragment has been added
        if (!mQuoteFragment.isAdded()) {

            // Make the TitleFragment occupy the entire layout
            mTitleFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(
                    MATCH_PARENT, MATCH_PARENT));
            mQuotesFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0,
                    MATCH_PARENT));
        } else {

            // Make the TitleLayout take 1/3 of the layout's width
            mTitleFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0,
                    MATCH_PARENT, 1f));

            // Make the QuoteLayout take 2/3's of the layout's width
            mQuotesFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0,
                    MATCH_PARENT, 2f));
        }
    }

    // Called when the user selects an item in the TitlesFragment
    @Override
    public void onListSelection(int index) {

        // if the phone is in landscape mode
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {

            // If the QuoteFragment has not been added, add it now
            if (!mQuoteFragment.isAdded()) {

                // Start a new FragmentTransaction
                FragmentTransaction fragmentTransaction = mFragmentManager
                        .beginTransaction();

                // Add the QuoteFragment to the layout
                fragmentTransaction.add(R.id.details,
                        mQuoteFragment);

                // Add this FragmentTransaction to the backstack
                fragmentTransaction.addToBackStack(null);

                // Commit the FragmentTransaction
                fragmentTransaction.commit();

                // Force Android to execute the committed FragmentTransaction
                mFragmentManager.executePendingTransactions();
            }

            if (mQuoteFragment.getShownIndex() != index) {

                // Tell the QuoteFragment to show the quote string at position index
                mQuoteFragment.showQuoteAtIndex(index);

            }

        }  else { // else if phone in portrait mode, start another activity to show interests points

            Intent intent = new Intent();
            // explicitly set the activity context and class
            // associated with the intent (context, class)
            intent.setClass(this, DetailsActivity.class);

            // pass the current position
            intent.putExtra("index", index);
            startActivity(intent);
        }
    }

    // FragmentLayout activity's Lifecycle
    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }
}