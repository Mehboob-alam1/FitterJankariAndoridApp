package com.fitterkipurijankarisalman.myapplication.activity;

        import androidx.annotation.NonNull;
        import androidx.appcompat.app.AppCompatActivity;

        import android.media.tv.AdRequest;
        import android.os.Bundle;
        import android.view.View;

        import com.fitterkipurijankarisalman.myapplication.R;
        import com.google.android.gms.ads.AdListener;
        import com.google.android.gms.ads.LoadAdError;
        import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
        import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
        import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.FullscreenListener;
        import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

        import kotlin.Unit;
        import kotlin.jvm.functions.Function0;

    public class header_hole_equal_tee_video extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_header_hole_equal_tee_video);


            YouTubePlayerView youTubePlayerView = findViewById(R.id.youtube_player_view);
            getLifecycle().addObserver(youTubePlayerView);

            youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
                @Override
                public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                    String videoId = "pACINKT17-M";
                    youTubePlayer.loadVideo(videoId, 0);



                    youTubePlayerView.addFullscreenListener(new FullscreenListener() {
                        @Override
                        public void onEnterFullscreen(@NonNull View fullscreenView, @NonNull Function0<Unit> exitFullscreen) {
                        }

                        @Override
                        public void onExitFullscreen() {
                        }
                    });
                }
            });
        }





    }