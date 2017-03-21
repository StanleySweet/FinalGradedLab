package fr.esilv.s8.finalgradedlab.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import fr.esilv.s8.finalgradedlab.R;
import fr.esilv.s8.finalgradedlab.model.Config;

public class VideoActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    private String videoId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        TextView videoTitleTextView = (TextView) findViewById(R.id.videoTitle);
        this.youTubeView = (YouTubePlayerView) findViewById(R.id.youtube_view);
        TextView youTuberTextView = (TextView) findViewById(R.id.youTuberTextView);
        TextView descriptionTextView = (TextView) findViewById(R.id.videoDescription);
        Bundle bundle = getIntent().getExtras();
        String searchedText = bundle.getString("VideoURL");
        if (searchedText != null) {
            videoId = bundle.getString("VideoURL");
        }
        String videoTitle = bundle.getString("Video Title");
        if (videoTitle != null) {
            videoTitleTextView.setText(videoTitle);
        }
        String youTuber = bundle.getString("YouTuber");
        if (youTuber != null) {
            youTuberTextView.setText(youTuber);
        }
        String description = bundle.getString("Description");
        if (youTuber != null) {
            descriptionTextView.setText(description);
        }

        this.youTubeView.initialize(Config.YOUTUBE_API_KEY, this);
    }

    public static void start(Context context, String id, String title, String youTuber, String description) {
        Intent intent = new Intent(context, VideoActivity.class);
        intent.putExtra("VideoURL", id);
        intent.putExtra("Video Title", title);
        intent.putExtra("YouTuber", youTuber);
        intent.putExtra("Description", description);
        context.startActivity(intent);
    }

    private static final int RECOVERY_REQUEST = 1;
    private YouTubePlayerView youTubeView;


    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {
        if (!wasRestored) {
            player.cueVideo(videoId);
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult errorReason) {
        if (errorReason.isUserRecoverableError()) {
            errorReason.getErrorDialog(this, RECOVERY_REQUEST).show();
        } else {
            String error = String.format(getString(R.string.player_error), errorReason.toString());
            Toast.makeText(this, error, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RECOVERY_REQUEST) {
            // Retry initialization if user performed a recovery action
            getYouTubePlayerProvider().initialize(Config.YOUTUBE_API_KEY, this);
        }
    }

    private YouTubePlayer.Provider getYouTubePlayerProvider() {
        return youTubeView;
    }
}
