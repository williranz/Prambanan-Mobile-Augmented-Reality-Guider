var World = {
	loaded: false,

	init: function initFn() {
		this.createOverlays();
	},

	createOverlays: function createOverlaysFn()
	{
		this.tracker = new AR.ClientTracker("assets/trackerprambanan.wtc",{
			onLoaded: this.worldLoaded
		});

		/*Image list, sound, and video -->models*/
 		var moreButtonImg = new AR.ImageResource("assets/moreButton.png");
 		var playButtonImg = new AR.ImageResource("assets/playButton.png");
 		var stopButtonImg = new AR.ImageResource("assets/stopButton.png");
 		var imgSparkles = new AR.ImageResource("assets/imageSparkles.png");

 		var imgOne1 = new AR.ImageResource("assets/lblsuamiistri.png");
 		var imgOne2 = new AR.ImageResource("assets/lblsinga.png");
 		var imgOne3 = new AR.ImageResource("assets/lblsingajaga.png");
 		var imgOne4 = new AR.ImageResource("assets/lblpotbunga.png");
 		var imgOne5 = new AR.ImageResource("assets/lblrusa.png");
 		var imgOne6 = new AR.ImageResource("assets/lblpasangan.png");
 		var imgOne7 = new AR.ImageResource("assets/lblmonyet.png");
 		var imgOne8 = new AR.ImageResource("assets/lblmerak.png");
 		var imgOne9 = new AR.ImageResource("assets/lblmacan.png");
 		var imgOne10 = new AR.ImageResource("assets/lblkelinci.png");
 		var imgOne11 = new AR.ImageResource("assets/lblentelop.png");
 		var imgOne12 = new AR.ImageResource("assets/lblgajah.png");
 		var imgOne13 = new AR.ImageResource("assets/lblduaorg.png");
 		var imgOne14 = new AR.ImageResource("assets/lbldewatua.png");
 		var imgOne15 = new AR.ImageResource("assets/lbldewamuda.png");
 		var imgOne16 = new AR.ImageResource("assets/lbldewatidur.png");
 		var imgOne17 = new AR.ImageResource("assets/lblceritamonyet.png");
 		var imgOne18 = new AR.ImageResource("assets/lbldewadalam.png");
 		var imgOne19 = new AR.ImageResource("assets/lblbersaudara.png");
 		var imgOne20 = new AR.ImageResource("assets/lblburunganeh.png");
 		var imgOne21 = new AR.ImageResource("assets/lblanakdewa.png");
 		var imgOne22 = new AR.ImageResource("assets/lblbangau.png");
 		var imgOne23 = new AR.ImageResource("assets/lblalurdewa.png");
 		var imgOne24 = new AR.ImageResource("assets/lblsumo.png");

		// Create play button which is used for starting the video
		var playImg = new AR.ImageResource("assets/videoplay.png");
		var play = new AR.ImageDrawable(playImg, 0.3,
		{
			enabled: false,
			clicked: false,
			onClick: function playClicked() {
				video.play(1);
				video.playing = true;
				play.clicked = true;
			},
			offsetY: -0.1
		});

		var video = new AR.VideoDrawable("assets/video.mp4", 0.7,
		{
			offsetY: -0.1,
			onLoaded: function videoLoaded() {
				play.enabled = true;
			},
			onPlaybackStarted: function videoPlaying() {
				play.enabled = false;
				video.enabled = true;
			},
			onFinishedPlaying: function videoFinished() {
				play.enabled = true;
				video.playing = false;
				video.enabled = false;
			},
			onClick: function videoClicked() {
				if (play.clicked) {
					play.clicked = false;
				} else if (video.playing) {
					video.pause();
					video.playing = false;
				} else {
					video.resume();
					video.playing = true;
				}
			}
		});

 		var alurdewa = new AR.Sound("assets/alurdewa.mp3", {
			 onError : function(e) {AR.logger.info("error playing sound: "+e);},
			 onFinishedPlaying : function() {AR.logger.info("Play Sound Finished...");},
			 onLoaded : function() {AR.logger.info("Loaded"); }
			 });
		alurdewa.load();

		var anakdewa = new AR.Sound("assets/anakdewa.mp3", {
			 onError : function(e) {AR.logger.info("error playing sound: "+e);},
			 onFinishedPlaying : function() {AR.logger.info("Play Sound Finished...");},
			 onLoaded : function() {AR.logger.info("Loaded"); }
			 });
        anakdewa.load();

        var bangau = new AR.Sound("assets/bangau.mp3", {
			 onError : function(e) {AR.logger.info("error playing sound: "+e);},
			 onFinishedPlaying : function() {AR.logger.info("Play Sound Finished...");},
			 onLoaded : function() {AR.logger.info("Loaded"); }
			 });
		bangau.load();

		var bersaudara = new AR.Sound("assets/bersaudara.mp3", {
			 onError : function(e) {AR.logger.info("error playing sound: "+e);},
			 onFinishedPlaying : function() {AR.logger.info("Play Sound Finished...");},
			 onLoaded : function() {AR.logger.info("Loaded"); }
			 });
        bersaudara.load();

        var burunganeh = new AR.Sound("assets/burunganeh.mp3", {
			 onError : function(e) {AR.logger.info("error playing sound: "+e);},
			 onFinishedPlaying : function() {AR.logger.info("Play Sound Finished...");},
			 onLoaded : function() {AR.logger.info("Loaded"); }
			 });
		burunganeh.load();

		var ceritamonyet = new AR.Sound("assets/ceritamonyet.mp3", {
			 onError : function(e) {AR.logger.info("error playing sound: "+e);},
			 onFinishedPlaying : function() {AR.logger.info("Play Sound Finished...");},
			 onLoaded : function() {AR.logger.info("Loaded"); }
			 });
		ceritamonyet.load();

		var dewadalam = new AR.Sound("assets/dewadalam.mp3", {
			 onError : function(e) {AR.logger.info("error playing sound: "+e);},
			 onFinishedPlaying : function() {AR.logger.info("Play Sound Finished...");},
			 onLoaded : function() {AR.logger.info("Loaded"); }
			 });
		dewadalam.load();

		var dewamuda = new AR.Sound("assets/dewamuda.mp3", {
			 onError : function(e) {AR.logger.info("error playing sound: "+e);},
			 onFinishedPlaying : function() {AR.logger.info("Play Sound Finished...");},
			 onLoaded : function() {AR.logger.info("Loaded"); }
			 });
		dewamuda.load();

		var dewatidur = new AR.Sound("assets/dewatidur.mp3", {
			 onError : function(e) {AR.logger.info("error playing sound: "+e);},
			 onFinishedPlaying : function() {AR.logger.info("Play Sound Finished...");},
			 onLoaded : function() {AR.logger.info("Loaded"); }
			 });
		dewatidur.load();

		var dewatua = new AR.Sound("assets/dewatua.mp3", {
			 onError : function(e) {AR.logger.info("error playing sound: "+e);},
			 onFinishedPlaying : function() {AR.logger.info("Play Sound Finished...");},
			 onLoaded : function() {AR.logger.info("Loaded"); }
			 });
		dewatua.load();

		var duaorg = new AR.Sound("assets/duaorg.mp3", {
			 onError : function(e) {AR.logger.info("error playing sound: "+e);},
			 onFinishedPlaying : function() {AR.logger.info("Play Sound Finished...");},
			 onLoaded : function() {AR.logger.info("Loaded"); }
			 });
		duaorg.load();

		var entelop = new AR.Sound("assets/entelop.mp3", {
			 onError : function(e) {AR.logger.info("error playing sound: "+e);},
			 onFinishedPlaying : function() {AR.logger.info("Play Sound Finished...");},
			 onLoaded : function() {AR.logger.info("Loaded"); }
			 });
		entelop.load();

		var gajah = new AR.Sound("assets/gajah.mp3", {
			 onError : function(e) {AR.logger.info("error playing sound: "+e);},
			 onFinishedPlaying : function() {AR.logger.info("Play Sound Finished...");},
			 onLoaded : function() {AR.logger.info("Loaded"); }
			 });
		gajah.load();

		var kelinci = new AR.Sound("assets/kelinci.mp3", {
			 onError : function(e) {AR.logger.info("error playing sound: "+e);},
			 onFinishedPlaying : function() {AR.logger.info("Play Sound Finished...");},
			 onLoaded : function() {AR.logger.info("Loaded"); }
			 });
		kelinci.load();

		var macan = new AR.Sound("assets/macan.mp3", {
			 onError : function(e) {AR.logger.info("error playing sound: "+e);},
			 onFinishedPlaying : function() {AR.logger.info("Play Sound Finished...");},
			 onLoaded : function() {AR.logger.info("Loaded"); }
			 });
		macan.load();

		var merak = new AR.Sound("assets/merak.mp3", {
			 onError : function(e) {AR.logger.info("error playing sound: "+e);},
			 onFinishedPlaying : function() {AR.logger.info("Play Sound Finished...");},
			 onLoaded : function() {AR.logger.info("Loaded"); }
			 });
		merak.load();

		var monyet = new AR.Sound("assets/monyet.mp3", {
			 onError : function(e) {AR.logger.info("error playing sound: "+e);},
			 onFinishedPlaying : function() {AR.logger.info("Play Sound Finished...");},
			 onLoaded : function() {AR.logger.info("Loaded"); }
			 });
		monyet.load();

		var pasangan = new AR.Sound("assets/pasangan.mp3", {
			 onError : function(e) {AR.logger.info("error playing sound: "+e);},
			 onFinishedPlaying : function() {AR.logger.info("Play Sound Finished...");},
			 onLoaded : function() {AR.logger.info("Loaded"); }
			 });
		pasangan.load();

		var potbunga = new AR.Sound("assets/potbunga.mp3", {
			 onError : function(e) {AR.logger.info("error playing sound: "+e);},
			 onFinishedPlaying : function() {AR.logger.info("Play Sound Finished...");},
			 onLoaded : function() {AR.logger.info("Loaded"); }
			 });
		potbunga.load();

		var rusa = new AR.Sound("assets/rusa.mp3", {
			 onError : function(e) {AR.logger.info("error playing sound: "+e);},
			 onFinishedPlaying : function() {AR.logger.info("Play Sound Finished...");},
			 onLoaded : function() {AR.logger.info("Loaded"); }
			 });
		rusa.load();

		var singa = new AR.Sound("assets/singa.mp3", {
			 onError : function(e) {AR.logger.info("error playing sound: "+e);},
			 onFinishedPlaying : function() {AR.logger.info("Play Sound Finished...");},
			 onLoaded : function() {AR.logger.info("Loaded"); }
			 });
		singa.load();

		var singajaga = new AR.Sound("assets/singajaga.mp3", {
			 onError : function(e) {AR.logger.info("error playing sound: "+e);},
			 onFinishedPlaying : function() {AR.logger.info("Play Sound Finished...");},
			 onLoaded : function() {AR.logger.info("Loaded"); }
			 });
		singajaga.load();

		var suamiistri = new AR.Sound("assets/suamiistri.mp3", {
			 onError : function(e) {AR.logger.info("error playing sound: "+e);},
			 onFinishedPlaying : function() {AR.logger.info("Play Sound Finished...");},
			 onLoaded : function() {AR.logger.info("Loaded"); }
			 });
		suamiistri.load();

		var sumo = new AR.Sound("assets/sumo.mp3", {
			 onError : function(e) {AR.logger.info("error playing sound: "+e);},
			 onFinishedPlaying : function() {AR.logger.info("Play Sound Finished...");},
			 onLoaded : function() {AR.logger.info("Loaded"); }
			 });
		sumo.load();

 		//variable list section 1========================================================================================================
        var moreButton1 = new AR.ImageDrawable(moreButtonImg, 0.25, {
            onClick: function moreButtonClicked()
            {
				AR.context.openInBrowser("https://googledrive.com/host/0BxQMyJVlV8MWRFdqblJhSTZIVGc/index1.html");
            },
            offsetX: -0.2,
            offsetY: -0.5,
        });


        var playButton1 = new AR.ImageDrawable(playButtonImg, 0.2, {
            onClick: function playButtonClicked()
            {
            	suamiistri.stop();
                suamiistri.play();
                enabled: false;
            },
            offsetX: 0.3,
            offsetY: -0.5,
        });

		var stopButton1 = new AR.ImageDrawable(stopButtonImg, 0.2, {
			onClick: function stopButtonClicked()
			{
				suamiistri.stop();
				enabled: false;
			},
			offsetX: 0.3,
			offsetY: -0.2,
		});

		var sparkles = new AR.AnimatedImageDrawable(imgSparkles, 0.25, 128, 128, {
			offsetX: 0.3,
			offsetY: 0.5,
			rotation: 75
		});
		sparkles.animate([0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15], 100, -1);


		var overlayOne1 = new AR.ImageDrawable(imgOne1, 0.3, {
			offsetX: -0.2,
			offsetY: 0.5
		});

		var pageOne = new AR.Trackable2DObject(this.tracker, "suamiistri", {
			drawables: {
				cam: [overlayOne1, moreButton1, playButton1, stopButton1, sparkles]
			},
			enableExtendedTracking: true,
			onExtendedTrackingQualityChanged: function (targetName, oldTrackingQuality, newTrackingQuality)
			{
				var backgroundColor;
				var trackingQualityText;

				if ( -1 == newTrackingQuality ) {
					backgroundColor = '#FF3420';
					trackingQualityText = 'Bad';
				} else if ( 0 == newTrackingQuality ) {
					backgroundColor = '#FFD900';
					trackingQualityText = 'Average';
				} else {
					backgroundColor = '#6BFF00';
					trackingQualityText = 'Good';
				}
				var cssDivInstructions = " style='display: table-cell;vertical-align: middle; text-align: middle; width: 50%; padding-right: 15px;'";
				var messageBox = document.getElementById('loadingMessage');
				messageBox.style.backgroundColor = backgroundColor;
				messageBox.innerHTML = "<div" + cssDivInstructions + ">Tracking Quality: " + trackingQualityText + "</div>";
				messageBox.style.display = 'block';
			},onExitFieldOfVision: function onExitFieldOfVisionFn() {suamiistri.stop();}
		});

		//variable list section 2===========================================================================================================================
		var moreButton2 = new AR.ImageDrawable(moreButtonImg, 0.25, {
			onClick: function moreButtonClicked()
			{
				AR.context.openInBrowser("https://googledrive.com/host/0BxQMyJVlV8MWRFdqblJhSTZIVGc/index2.html");
			},
			offsetX: -0.2,
			offsetY: -0.5,
		});

		 var playButton2 = new AR.ImageDrawable(playButtonImg, 0.2, {
			onClick: function playButtonClicked()
			{
				singa.stop();
				singa.play();
				enabled: false;
			},
			offsetX: 0.3,
			offsetY: -0.5,
		 });

		var stopButton2 = new AR.ImageDrawable(stopButtonImg, 0.2, {
			onClick: function stopButtonClicked()
			{
				singa.stop();
				enabled: false;
			},
			offsetX: 0.3,
			offsetY: -0.2,
		});

		var overlayOne2 = new AR.ImageDrawable(imgOne2, 0.3, {
			offsetX: -0.2,
			offsetY: 0.5
		});

		var pageTwo = new AR.Trackable2DObject(this.tracker, "singa", {
			drawables: {
				cam: [overlayOne2, moreButton2, playButton2, stopButton2, sparkles]
			},
			enableExtendedTracking: true,
			onExtendedTrackingQualityChanged: function (targetName, oldTrackingQuality, newTrackingQuality)
			{
				var backgroundColor;
				var trackingQualityText;

				if ( -1 == newTrackingQuality ) {
					backgroundColor = '#FF3420';
					trackingQualityText = 'Bad';
				} else if ( 0 == newTrackingQuality ) {
					backgroundColor = '#FFD900';
					trackingQualityText = 'Average';
				} else {
					backgroundColor = '#6BFF00';
					trackingQualityText = 'Good';
				}
				var cssDivInstructions = " style='display: table-cell;vertical-align: middle; text-align: middle; width: 50%; padding-right: 15px;'";
				var messageBox = document.getElementById('loadingMessage');
				messageBox.style.backgroundColor = backgroundColor;
				messageBox.innerHTML = "<div" + cssDivInstructions + ">Tracking Quality: " + trackingQualityText + "</div>";
				messageBox.style.display = 'block';
			},onExitFieldOfVision: function onExitFieldOfVisionFn() {singa.stop();}
		});

		//variable list section 3===========================================================================================================================
		var moreButton3 = new AR.ImageDrawable(moreButtonImg, 0.25, {
			onClick: function moreButtonClicked()
			{
				AR.context.openInBrowser("https://googledrive.com/host/0BxQMyJVlV8MWRFdqblJhSTZIVGc/index3.html");
			},
			offsetX: -0.2,
			offsetY: -0.5,
		});

		var playButton3 = new AR.ImageDrawable(playButtonImg, 0.2, {
			onClick: function playButtonClicked()
			{
				singajaga.stop();
				singajaga.play();
				enabled: false;
			},
			offsetX: 0.3,
			offsetY: -0.5,
		});

		var stopButton3 = new AR.ImageDrawable(stopButtonImg, 0.2, {
			onClick: function stopButtonClicked()
			{
				singajaga.stop();
				enabled: false;
			},
			offsetX: 0.3,
			offsetY: -0.2,
		});

		var overlayOne3 = new AR.ImageDrawable(imgOne3, 0.3, {
			offsetX: -0.2,
			offsetY: 0.5
		});

		var pageThree = new AR.Trackable2DObject(this.tracker, "singajaga", {
			drawables: {
				cam: [overlayOne3, moreButton3, playButton3, stopButton3, sparkles]
			},
			enableExtendedTracking: true,
			onExtendedTrackingQualityChanged: function (targetName, oldTrackingQuality, newTrackingQuality)
			{
				var backgroundColor;
				var trackingQualityText;

				if ( -1 == newTrackingQuality ) {
					backgroundColor = '#FF3420';
					trackingQualityText = 'Bad';
				} else if ( 0 == newTrackingQuality ) {
					backgroundColor = '#FFD900';
					trackingQualityText = 'Average';
				} else {
					backgroundColor = '#6BFF00';
					trackingQualityText = 'Good';
				}
				var cssDivInstructions = " style='display: table-cell;vertical-align: middle; text-align: middle; width: 50%; padding-right: 15px;'";
				var messageBox = document.getElementById('loadingMessage');
				messageBox.style.backgroundColor = backgroundColor;
				messageBox.innerHTML = "<div" + cssDivInstructions + ">Tracking Quality: " + trackingQualityText + "</div>";
				messageBox.style.display = 'block';
			},onExitFieldOfVision: function onExitFieldOfVisionFn() {singajaga.stop();}
		});

		//variable list section 4===========================================================================================================================
		var moreButton4 = new AR.ImageDrawable(moreButtonImg, 0.25, {
			onClick: function moreButtonClicked()
			{
				AR.context.openInBrowser("https://googledrive.com/host/0BxQMyJVlV8MWRFdqblJhSTZIVGc/index4.html");
			},
			offsetX: -0.2,
			offsetY: -0.5,
		});

		var playButton4 = new AR.ImageDrawable(playButtonImg, 0.2, {
			onClick: function playButtonClicked()
			{
				potbunga.stop();
				potbunga.play();
				enabled: false;
			},
			offsetX: 0.3,
			offsetY: -0.5,
		});

		var stopButton4 = new AR.ImageDrawable(stopButtonImg, 0.2, {
			onClick: function stopButtonClicked()
			{
				potbunga.stop();
				enabled: false;
			},
			offsetX: 0.3,
			offsetY: -0.2,
		});

		var overlayOne4 = new AR.ImageDrawable(imgOne4, 0.3, {
			offsetX: -0.2,
			offsetY: 0.5
		});

		var pageFour = new AR.Trackable2DObject(this.tracker, "potbunga", {
			drawables: {
				cam: [overlayOne4, moreButton4, playButton4, stopButton4, sparkles]
			},
			enableExtendedTracking: true,
			onExtendedTrackingQualityChanged: function (targetName, oldTrackingQuality, newTrackingQuality)
			{
				var backgroundColor;
				var trackingQualityText;

				if ( -1 == newTrackingQuality ) {
					backgroundColor = '#FF3420';
					trackingQualityText = 'Bad';
				} else if ( 0 == newTrackingQuality ) {
					backgroundColor = '#FFD900';
					trackingQualityText = 'Average';
				} else {
					backgroundColor = '#6BFF00';
					trackingQualityText = 'Good';
				}
				var cssDivInstructions = " style='display: table-cell;vertical-align: middle; text-align: middle; width: 50%; padding-right: 15px;'";
				var messageBox = document.getElementById('loadingMessage');
				messageBox.style.backgroundColor = backgroundColor;
				messageBox.innerHTML = "<div" + cssDivInstructions + ">Tracking Quality: " + trackingQualityText + "</div>";
				messageBox.style.display = 'block';
			},onExitFieldOfVision: function onExitFieldOfVisionFn() {potbunga.stop();}
		});

		//variable list section 5===========================================================================================================================
		var moreButton5 = new AR.ImageDrawable(moreButtonImg, 0.25, {
			onClick: function moreButtonClicked()
			{
				AR.context.openInBrowser("https://googledrive.com/host/0BxQMyJVlV8MWRFdqblJhSTZIVGc/index5.html");
			},
			offsetX: -0.2,
			offsetY: -0.5,
		});

		var playButton5 = new AR.ImageDrawable(playButtonImg, 0.2, {
			onClick: function playButtonClicked()
			{
				rusa.stop();
				rusa.play();
				enabled: false;
			},
			offsetX: 0.3,
			offsetY: -0.5,
		});

		var stopButton5 = new AR.ImageDrawable(stopButtonImg, 0.2, {
			onClick: function stopButtonClicked()
			{
				rusa.stop();
				enabled: false;
			},
			offsetX: 0.3,
			offsetY: -0.2,
		});

		var overlayOne5 = new AR.ImageDrawable(imgOne5, 0.3, {
			offsetX: -0.2,
			offsetY: 0.5
		});

		var pageFive = new AR.Trackable2DObject(this.tracker, "rusa", {
			drawables: {
				cam: [overlayOne5, moreButton5, playButton5, stopButton5, sparkles]
			},
			enableExtendedTracking: true,
			onExtendedTrackingQualityChanged: function (targetName, oldTrackingQuality, newTrackingQuality)
			{
				var backgroundColor;
				var trackingQualityText;

				if ( -1 == newTrackingQuality ) {
					backgroundColor = '#FF3420';
					trackingQualityText = 'Bad';
				} else if ( 0 == newTrackingQuality ) {
					backgroundColor = '#FFD900';
					trackingQualityText = 'Average';
				} else {
					backgroundColor = '#6BFF00';
					trackingQualityText = 'Good';
				}
				var cssDivInstructions = " style='display: table-cell;vertical-align: middle; text-align: middle; width: 50%; padding-right: 15px;'";
				var messageBox = document.getElementById('loadingMessage');
				messageBox.style.backgroundColor = backgroundColor;
				messageBox.innerHTML = "<div" + cssDivInstructions + ">Tracking Quality: " + trackingQualityText + "</div>";
				messageBox.style.display = 'block';
			},onExitFieldOfVision: function onExitFieldOfVisionFn() {rusa.stop();}
		});

		//variable list section 6===========================================================================================================================
		var moreButton6 = new AR.ImageDrawable(moreButtonImg, 0.25, {
			onClick: function moreButtonClicked()
			{
				AR.context.openInBrowser("https://googledrive.com/host/0BxQMyJVlV8MWRFdqblJhSTZIVGc/index6.html");
			},
			offsetX: -0.2,
			offsetY: -0.5,
		});

		var playButton6 = new AR.ImageDrawable(playButtonImg, 0.2, {
			onClick: function playButtonClicked()
			{
				pasangan.stop();
				pasangan.play();
				enabled: false;
			},
			offsetX: 0.3,
			offsetY: -0.5,
		});

		var stopButton6 = new AR.ImageDrawable(stopButtonImg, 0.2, {
			onClick: function stopButtonClicked()
			{
				pasangan.stop();
				enabled: false;
			},
			offsetX: 0.3,
			offsetY: -0.2,
		});

		var overlayOne6 = new AR.ImageDrawable(imgOne6, 0.3, {
			offsetX: -0.2,
			offsetY: 0.5
		});

		var pageSix = new AR.Trackable2DObject(this.tracker, "pasangan", {
			drawables: {
				cam: [overlayOne6, moreButton6, playButton6, stopButton6, sparkles]
			},
			enableExtendedTracking: true,
			onExtendedTrackingQualityChanged: function (targetName, oldTrackingQuality, newTrackingQuality)
			{
				var backgroundColor;
				var trackingQualityText;

				if ( -1 == newTrackingQuality ) {
					backgroundColor = '#FF3420';
					trackingQualityText = 'Bad';
				} else if ( 0 == newTrackingQuality ) {
					backgroundColor = '#FFD900';
					trackingQualityText = 'Average';
				} else {
					backgroundColor = '#6BFF00';
					trackingQualityText = 'Good';
				}
				var cssDivInstructions = " style='display: table-cell;vertical-align: middle; text-align: middle; width: 50%; padding-right: 15px;'";
				var messageBox = document.getElementById('loadingMessage');
				messageBox.style.backgroundColor = backgroundColor;
				messageBox.innerHTML = "<div" + cssDivInstructions + ">Tracking Quality: " + trackingQualityText + "</div>";
				messageBox.style.display = 'block';
			},onExitFieldOfVision: function onExitFieldOfVisionFn() {pasangan.stop();}
		});

		//variable list section 7===========================================================================================================================
        var moreButton7 = new AR.ImageDrawable(moreButtonImg, 0.25, {
			onClick: function moreButtonClicked()
			{
				AR.context.openInBrowser("https://googledrive.com/host/0BxQMyJVlV8MWRFdqblJhSTZIVGc/index7.html");
			},
			offsetX: -0.2,
			offsetY: -0.5,
		});

		var playButton7 = new AR.ImageDrawable(playButtonImg, 0.2, {
			onClick: function playButtonClicked()
			{
				monyet.stop();
				monyet.play();
				enabled: false;
			},
			offsetX: 0.3,
			offsetY: -0.5,
		});

		var stopButton7 = new AR.ImageDrawable(stopButtonImg, 0.2, {
			onClick: function stopButtonClicked()
			{
				monyet.stop();
				enabled: false;
			},
			offsetX: 0.3,
			offsetY: -0.2,
		});

		var overlayOne7 = new AR.ImageDrawable(imgOne7, 0.3, {
			offsetX: -0.2,
			offsetY: 0.5
		});

        var pageSeven = new AR.Trackable2DObject(this.tracker, "monyet", {
			drawables: {
				cam: [overlayOne7, moreButton7, playButton7, stopButton7, sparkles]
			},
			enableExtendedTracking: true,
			onExtendedTrackingQualityChanged: function (targetName, oldTrackingQuality, newTrackingQuality)
			{
				var backgroundColor;
				var trackingQualityText;

				if ( -1 == newTrackingQuality ) {
					backgroundColor = '#FF3420';
					trackingQualityText = 'Bad';
				} else if ( 0 == newTrackingQuality ) {
					backgroundColor = '#FFD900';
					trackingQualityText = 'Average';
				} else {
					backgroundColor = '#6BFF00';
					trackingQualityText = 'Good';
				}
				var cssDivInstructions = " style='display: table-cell;vertical-align: middle; text-align: middle; width: 50%; padding-right: 15px;'";
				var messageBox = document.getElementById('loadingMessage');
				messageBox.style.backgroundColor = backgroundColor;
				messageBox.innerHTML = "<div" + cssDivInstructions + ">Tracking Quality: " + trackingQualityText + "</div>";
				messageBox.style.display = 'block';
			},onExitFieldOfVision: function onExitFieldOfVisionFn() {monyet.stop();}
		});

        //variable list section 8===========================================================================================================================
        var moreButton8 = new AR.ImageDrawable(moreButtonImg, 0.25, {
			onClick: function moreButtonClicked()
			{
				AR.context.openInBrowser("https://googledrive.com/host/0BxQMyJVlV8MWRFdqblJhSTZIVGc/index8.html");
			},
			offsetX: -0.2,
			offsetY: -0.5,
		});

		var playButton8 = new AR.ImageDrawable(playButtonImg, 0.2, {
			onClick: function playButtonClicked()
			{
				merak.stop();
				merak.play();
				enabled: false;
			},
			offsetX: 0.3,
			offsetY: -0.5,
		});

		var stopButton8 = new AR.ImageDrawable(stopButtonImg, 0.2, {
			onClick: function stopButtonClicked()
			{
				merak.stop();
				enabled: false;
			},
			offsetX: 0.3,
			offsetY: -0.2,
		});

		var overlayOne8 = new AR.ImageDrawable(imgOne8, 0.3, {
			offsetX: -0.2,
			offsetY: 0.5
		});

        var pageEight = new AR.Trackable2DObject(this.tracker, "merak", {
			drawables: {
				cam: [overlayOne8, moreButton8, playButton8, stopButton8, sparkles]
			},
			enableExtendedTracking: true,
			onExtendedTrackingQualityChanged: function (targetName, oldTrackingQuality, newTrackingQuality)
			{
				var backgroundColor;
				var trackingQualityText;

				if ( -1 == newTrackingQuality ) {
					backgroundColor = '#FF3420';
					trackingQualityText = 'Bad';
				} else if ( 0 == newTrackingQuality ) {
					backgroundColor = '#FFD900';
					trackingQualityText = 'Average';
				} else {
					backgroundColor = '#6BFF00';
					trackingQualityText = 'Good';
				}
				var cssDivInstructions = " style='display: table-cell;vertical-align: middle; text-align: middle; width: 50%; padding-right: 15px;'";
				var messageBox = document.getElementById('loadingMessage');
				messageBox.style.backgroundColor = backgroundColor;
				messageBox.innerHTML = "<div" + cssDivInstructions + ">Tracking Quality: " + trackingQualityText + "</div>";
				messageBox.style.display = 'block';
			},onExitFieldOfVision: function onExitFieldOfVisionFn() {merak.stop();}
		});

        //variable list section 9===========================================================================================================================
        var moreButton9 = new AR.ImageDrawable(moreButtonImg, 0.25, {
			onClick: function moreButtonClicked()
			{
				AR.context.openInBrowser("https://googledrive.com/host/0BxQMyJVlV8MWRFdqblJhSTZIVGc/index9.html");
			},
			offsetX: -0.2,
			offsetY: -0.5,
		});

		var playButton9 = new AR.ImageDrawable(playButtonImg, 0.2, {
			onClick: function playButtonClicked()
			{
				macan.stop();
				macan.play();
				enabled: false;
			},
			offsetX: 0.3,
			offsetY: -0.5,
		});

		var stopButton9 = new AR.ImageDrawable(stopButtonImg, 0.2, {
			onClick: function stopButtonClicked()
			{
				macan.stop();
				enabled: false;
			},
			offsetX: 0.3,
			offsetY: -0.2,
		});

		var overlayOne9 = new AR.ImageDrawable(imgOne9, 0.3, {
			offsetX: -0.2,
			offsetY: 0.5
		});

        var pageNine = new AR.Trackable2DObject(this.tracker, "macan", {
			drawables: {
				cam: [overlayOne9, moreButton9, playButton9, stopButton9, sparkles]
			},
			enableExtendedTracking: true,
			onExtendedTrackingQualityChanged: function (targetName, oldTrackingQuality, newTrackingQuality)
			{
				var backgroundColor;
				var trackingQualityText;

				if ( -1 == newTrackingQuality ) {
					backgroundColor = '#FF3420';
					trackingQualityText = 'Bad';
				} else if ( 0 == newTrackingQuality ) {
					backgroundColor = '#FFD900';
					trackingQualityText = 'Average';
				} else {
					backgroundColor = '#6BFF00';
					trackingQualityText = 'Good';
				}
				var cssDivInstructions = " style='display: table-cell;vertical-align: middle; text-align: middle; width: 50%; padding-right: 15px;'";
				var messageBox = document.getElementById('loadingMessage');
				messageBox.style.backgroundColor = backgroundColor;
				messageBox.innerHTML = "<div" + cssDivInstructions + ">Tracking Quality: " + trackingQualityText + "</div>";
				messageBox.style.display = 'block';
			},onExitFieldOfVision: function onExitFieldOfVisionFn() {macan.stop();}
		});

        //variable list section 10===========================================================================================================================
        var moreButton10 = new AR.ImageDrawable(moreButtonImg, 0.25, {
			onClick: function moreButtonClicked()
			{
				AR.context.openInBrowser("https://googledrive.com/host/0BxQMyJVlV8MWRFdqblJhSTZIVGc/index10.html");
			},
			offsetX: -0.2,
			offsetY: -0.5,
		});

		var playButton10 = new AR.ImageDrawable(playButtonImg, 0.2, {
			onClick: function playButtonClicked()
			{
				kelinci.stop();
				kelinci.play();
				enabled: false;
			},
			offsetX: 0.3,
			offsetY: -0.5,
		});

		var stopButton10 = new AR.ImageDrawable(stopButtonImg, 0.2, {
			onClick: function stopButtonClicked()
			{
				kelinci.stop();
				enabled: false;
			},
			offsetX: 0.3,
			offsetY: -0.2,
		});

		var overlayOne10 = new AR.ImageDrawable(imgOne10, 0.3, {
			offsetX: -0.2,
			offsetY: 0.5
		});

        var pageTen = new AR.Trackable2DObject(this.tracker, "kelinci", {
			drawables: {
				cam: [overlayOne10, moreButton10, playButton10, stopButton10, sparkles]
			},
			enableExtendedTracking: true,
			onExtendedTrackingQualityChanged: function (targetName, oldTrackingQuality, newTrackingQuality)
			{
				var backgroundColor;
				var trackingQualityText;

				if ( -1 == newTrackingQuality ) {
					backgroundColor = '#FF3420';
					trackingQualityText = 'Bad';
				} else if ( 0 == newTrackingQuality ) {
					backgroundColor = '#FFD900';
					trackingQualityText = 'Average';
				} else {
					backgroundColor = '#6BFF00';
					trackingQualityText = 'Good';
				}
				var cssDivInstructions = " style='display: table-cell;vertical-align: middle; text-align: middle; width: 50%; padding-right: 15px;'";
				var messageBox = document.getElementById('loadingMessage');
				messageBox.style.backgroundColor = backgroundColor;
				messageBox.innerHTML = "<div" + cssDivInstructions + ">Tracking Quality: " + trackingQualityText + "</div>";
				messageBox.style.display = 'block';
			},onExitFieldOfVision: function onExitFieldOfVisionFn() {kelinci.stop();}
		});

        //variable list section 11===========================================================================================================================
        var moreButton11 = new AR.ImageDrawable(moreButtonImg, 0.25, {
			onClick: function moreButtonClicked()
			{
				AR.context.openInBrowser("https://googledrive.com/host/0BxQMyJVlV8MWRFdqblJhSTZIVGc/index11.html");
			},
			offsetX: -0.2,
			offsetY: -0.5,
		});

		var playButton11 = new AR.ImageDrawable(playButtonImg, 0.2, {
			onClick: function playButtonClicked()
			{
				entelop.stop();
				entelop.play();
				enabled: false;
			},
			offsetX: 0.3,
			offsetY: -0.5,
		});

		var stopButton11 = new AR.ImageDrawable(stopButtonImg, 0.2, {
			onClick: function stopButtonClicked()
			{
				entelop.stop();
				enabled: false;
			},
			offsetX: 0.3,
			offsetY: -0.2,
		});

		var overlayOne11 = new AR.ImageDrawable(imgOne11, 0.3, {
			offsetX: -0.2,
			offsetY: 0.5
		});

        var pageEleven = new AR.Trackable2DObject(this.tracker, "entelop", {
			drawables: {
				cam: [overlayOne11, moreButton11, playButton11, stopButton11, sparkles]
			},
			enableExtendedTracking: true,
			onExtendedTrackingQualityChanged: function (targetName, oldTrackingQuality, newTrackingQuality)
			{
				var backgroundColor;
				var trackingQualityText;

				if ( -1 == newTrackingQuality ) {
					backgroundColor = '#FF3420';
					trackingQualityText = 'Bad';
				} else if ( 0 == newTrackingQuality ) {
					backgroundColor = '#FFD900';
					trackingQualityText = 'Average';
				} else {
					backgroundColor = '#6BFF00';
					trackingQualityText = 'Good';
				}
				var cssDivInstructions = " style='display: table-cell;vertical-align: middle; text-align: middle; width: 50%; padding-right: 15px;'";
				var messageBox = document.getElementById('loadingMessage');
				messageBox.style.backgroundColor = backgroundColor;
				messageBox.innerHTML = "<div" + cssDivInstructions + ">Tracking Quality: " + trackingQualityText + "</div>";
				messageBox.style.display = 'block';
			},onExitFieldOfVision: function onExitFieldOfVisionFn() {entelop.stop();}
		});

        //variable list section 12===========================================================================================================================
        var moreButton12 = new AR.ImageDrawable(moreButtonImg, 0.25, {
			onClick: function moreButtonClicked()
			{
				AR.context.openInBrowser("https://googledrive.com/host/0BxQMyJVlV8MWRFdqblJhSTZIVGc/index12.html");
			},
			offsetX: -0.2,
			offsetY: -0.5,
		});

		var playButton12 = new AR.ImageDrawable(playButtonImg, 0.2, {
			onClick: function playButtonClicked()
			{
				gajah.stop();
				gajah.play();
				enabled: false;
			},
			offsetX: 0.3,
			offsetY: -0.5,
		});

		var stopButton12 = new AR.ImageDrawable(stopButtonImg, 0.2, {
			onClick: function stopButtonClicked()
			{
				gajah.stop();
				enabled: false;
			},
			offsetX: 0.3,
			offsetY: -0.2,
		});

		var overlayOne12 = new AR.ImageDrawable(imgOne12, 0.3, {
			offsetX: -0.2,
			offsetY: 0.5
		});

        var pageTwelve = new AR.Trackable2DObject(this.tracker, "gajah", {
			drawables: {
				cam: [overlayOne12, moreButton12, playButton12, stopButton12, sparkles]
			},
			enableExtendedTracking: true,
			onExtendedTrackingQualityChanged: function (targetName, oldTrackingQuality, newTrackingQuality)
			{
				var backgroundColor;
				var trackingQualityText;

				if ( -1 == newTrackingQuality ) {
					backgroundColor = '#FF3420';
					trackingQualityText = 'Bad';
				} else if ( 0 == newTrackingQuality ) {
					backgroundColor = '#FFD900';
					trackingQualityText = 'Average';
				} else {
					backgroundColor = '#6BFF00';
					trackingQualityText = 'Good';
				}
				var cssDivInstructions = " style='display: table-cell;vertical-align: middle; text-align: middle; width: 50%; padding-right: 15px;'";
				var messageBox = document.getElementById('loadingMessage');
				messageBox.style.backgroundColor = backgroundColor;
				messageBox.innerHTML = "<div" + cssDivInstructions + ">Tracking Quality: " + trackingQualityText + "</div>";
				messageBox.style.display = 'block';
			},onExitFieldOfVision: function onExitFieldOfVisionFn() {gajah.stop();}
		});

        //variable list section 13===========================================================================================================================
        var moreButton13 = new AR.ImageDrawable(moreButtonImg, 0.25, {
			onClick: function moreButtonClicked()
			{
				AR.context.openInBrowser("https://googledrive.com/host/0BxQMyJVlV8MWRFdqblJhSTZIVGc/index13.html");
			},
			offsetX: -0.2,
			offsetY: -0.5,
		});

		var playButton13 = new AR.ImageDrawable(playButtonImg, 0.2, {
			onClick: function playButtonClicked()
			{
				duaorg.stop();
				duaorg.play();
				enabled: false;
			},
			offsetX: 0.3,
			offsetY: -0.5,
		});

		var stopButton13 = new AR.ImageDrawable(stopButtonImg, 0.2, {
			onClick: function stopButtonClicked()
			{
				duaorg.stop();
				enabled: false;
			},
			offsetX: 0.3,
			offsetY: -0.2,
		});

		var overlayOne13 = new AR.ImageDrawable(imgOne13, 0.3, {
			offsetX: -0.2,
			offsetY: 0.5
		});

        var pageThirteen = new AR.Trackable2DObject(this.tracker, "duaorg", {
			drawables: {
				cam: [overlayOne13, moreButton13, playButton13, stopButton13, sparkles]
			},
			enableExtendedTracking: true,
			onExtendedTrackingQualityChanged: function (targetName, oldTrackingQuality, newTrackingQuality)
			{
				var backgroundColor;
				var trackingQualityText;

				if ( -1 == newTrackingQuality ) {
					backgroundColor = '#FF3420';
					trackingQualityText = 'Bad';
				} else if ( 0 == newTrackingQuality ) {
					backgroundColor = '#FFD900';
					trackingQualityText = 'Average';
				} else {
					backgroundColor = '#6BFF00';
					trackingQualityText = 'Good';
				}
				var cssDivInstructions = " style='display: table-cell;vertical-align: middle; text-align: middle; width: 50%; padding-right: 15px;'";
				var messageBox = document.getElementById('loadingMessage');
				messageBox.style.backgroundColor = backgroundColor;
				messageBox.innerHTML = "<div" + cssDivInstructions + ">Tracking Quality: " + trackingQualityText + "</div>";
				messageBox.style.display = 'block';
			},onExitFieldOfVision: function onExitFieldOfVisionFn() {duaorg.stop();}
		});

        //variable list section 14===========================================================================================================================
		var moreButton14 = new AR.ImageDrawable(moreButtonImg, 0.25, {
			onClick: function moreButtonClicked()
			{
				AR.context.openInBrowser("https://googledrive.com/host/0BxQMyJVlV8MWRFdqblJhSTZIVGc/index14.html");
			},
			offsetX: -0.2,
			offsetY: -0.5,
		});

		var playButton14 = new AR.ImageDrawable(playButtonImg, 0.2, {
			onClick: function playButtonClicked()
			{
				dewatua.stop();
				dewatua.play();
				enabled: false;
			},
			offsetX: 0.3,
			offsetY: -0.5,
		});

		var stopButton14 = new AR.ImageDrawable(stopButtonImg, 0.2, {
			onClick: function stopButtonClicked()
			{
				dewatua.stop();
				enabled: false;
			},
			offsetX: 0.3,
			offsetY: -0.2,
		});

		var overlayOne14 = new AR.ImageDrawable(imgOne14, 0.3, {
			offsetX: -0.2,
			offsetY: 0.5
		});

		var pageFourteen = new AR.Trackable2DObject(this.tracker, "dewatua", {
			drawables: {
				cam: [overlayOne14, moreButton14, playButton14, stopButton14, sparkles]
			},
			enableExtendedTracking: true,
			onExtendedTrackingQualityChanged: function (targetName, oldTrackingQuality, newTrackingQuality)
			{
				var backgroundColor;
				var trackingQualityText;

				if ( -1 == newTrackingQuality ) {
					backgroundColor = '#FF3420';
					trackingQualityText = 'Bad';
				} else if ( 0 == newTrackingQuality ) {
					backgroundColor = '#FFD900';
					trackingQualityText = 'Average';
				} else {
					backgroundColor = '#6BFF00';
					trackingQualityText = 'Good';
				}
				var cssDivInstructions = " style='display: table-cell;vertical-align: middle; text-align: middle; width: 50%; padding-right: 15px;'";
				var messageBox = document.getElementById('loadingMessage');
				messageBox.style.backgroundColor = backgroundColor;
				messageBox.innerHTML = "<div" + cssDivInstructions + ">Tracking Quality: " + trackingQualityText + "</div>";
				messageBox.style.display = 'block';
			},onExitFieldOfVision: function onExitFieldOfVisionFn() {dewatua.stop();}
		});

        //variable list section 15===========================================================================================================================
		var moreButton15 = new AR.ImageDrawable(moreButtonImg, 0.25, {
			onClick: function moreButtonClicked()
			{
				AR.context.openInBrowser("https://googledrive.com/host/0BxQMyJVlV8MWRFdqblJhSTZIVGc/index15.html");
			},
			offsetX: -0.2,
			offsetY: -0.5,
		});

		var playButton15 = new AR.ImageDrawable(playButtonImg, 0.2, {
			onClick: function playButtonClicked()
			{
				dewamuda.stop();
				dewamuda.play();
				enabled: false;
			},
			offsetX: 0.3,
			offsetY: -0.5,
		});

		var stopButton15 = new AR.ImageDrawable(stopButtonImg, 0.2, {
			onClick: function stopButtonClicked()
			{
				dewamuda.stop();
				enabled: false;
			},
			offsetX: 0.3,
			offsetY: -0.2,
		});

		var overlayOne15 = new AR.ImageDrawable(imgOne15, 0.3, {
			offsetX: -0.2,
			offsetY: 0.5
		});

		var pageFifteen = new AR.Trackable2DObject(this.tracker, "dewamuda", {
			drawables: {
				cam: [overlayOne15, moreButton15, playButton15, stopButton15, sparkles]
			},
			enableExtendedTracking: true,
			onExtendedTrackingQualityChanged: function (targetName, oldTrackingQuality, newTrackingQuality)
			{
				var backgroundColor;
				var trackingQualityText;

				if ( -1 == newTrackingQuality ) {
					backgroundColor = '#FF3420';
					trackingQualityText = 'Bad';
				} else if ( 0 == newTrackingQuality ) {
					backgroundColor = '#FFD900';
					trackingQualityText = 'Average';
				} else {
					backgroundColor = '#6BFF00';
					trackingQualityText = 'Good';
				}
				var cssDivInstructions = " style='display: table-cell;vertical-align: middle; text-align: middle; width: 50%; padding-right: 15px;'";
				var messageBox = document.getElementById('loadingMessage');
				messageBox.style.backgroundColor = backgroundColor;
				messageBox.innerHTML = "<div" + cssDivInstructions + ">Tracking Quality: " + trackingQualityText + "</div>";
				messageBox.style.display = 'block';
			},onExitFieldOfVision: function onExitFieldOfVisionFn() {dewamuda.stop();}
		});

        //variable list section 16===========================================================================================================================
		var moreButton16 = new AR.ImageDrawable(moreButtonImg, 0.25, {
			onClick: function moreButtonClicked()
			{
				AR.context.openInBrowser("https://googledrive.com/host/0BxQMyJVlV8MWRFdqblJhSTZIVGc/index16.html");
			},
			offsetX: -0.2,
			offsetY: -0.5,
		});

		var playButton16 = new AR.ImageDrawable(playButtonImg, 0.2, {
			onClick: function playButtonClicked()
			{
				dewatidur.stop();
				dewatidur.play();
				enabled: false;
			},
			offsetX: 0.3,
			offsetY: -0.5,
		});

		var stopButton16 = new AR.ImageDrawable(stopButtonImg, 0.2, {
			onClick: function stopButtonClicked()
			{
				dewatidur.stop();
				enabled: false;
			},
			offsetX: 0.3,
			offsetY: -0.2,
		});

		var overlayOne16 = new AR.ImageDrawable(imgOne16, 0.3, {
			offsetX: -0.2,
			offsetY: 0.5
		});

		var pageSixteen = new AR.Trackable2DObject(this.tracker, "dewatidur", {
			drawables: {
				cam: [overlayOne16, moreButton16, playButton16, stopButton16, sparkles]
			},
			enableExtendedTracking: true,
			onExtendedTrackingQualityChanged: function (targetName, oldTrackingQuality, newTrackingQuality)
			{
				var backgroundColor;
				var trackingQualityText;

				if ( -1 == newTrackingQuality ) {
					backgroundColor = '#FF3420';
					trackingQualityText = 'Bad';
				} else if ( 0 == newTrackingQuality ) {
					backgroundColor = '#FFD900';
					trackingQualityText = 'Average';
				} else {
					backgroundColor = '#6BFF00';
					trackingQualityText = 'Good';
				}
				var cssDivInstructions = " style='display: table-cell;vertical-align: middle; text-align: middle; width: 50%; padding-right: 15px;'";
				var messageBox = document.getElementById('loadingMessage');
				messageBox.style.backgroundColor = backgroundColor;
				messageBox.innerHTML = "<div" + cssDivInstructions + ">Tracking Quality: " + trackingQualityText + "</div>";
				messageBox.style.display = 'block';
			},onExitFieldOfVision: function onExitFieldOfVisionFn() {dewatidur.stop();}
		});

        //variable list section 17===========================================================================================================================
		var moreButton17 = new AR.ImageDrawable(moreButtonImg, 0.25, {
			onClick: function moreButtonClicked()
			{
				AR.context.openInBrowser("https://googledrive.com/host/0BxQMyJVlV8MWRFdqblJhSTZIVGc/index17.html");
			},
			offsetX: -0.2,
			offsetY: -0.5,
		});

		var playButton17 = new AR.ImageDrawable(playButtonImg, 0.2, {
			onClick: function playButtonClicked()
			{
				ceritamonyet.stop();
				ceritamonyet.play();
				enabled: false;
			},
			offsetX: 0.3,
			offsetY: -0.5,
		});

		var stopButton17 = new AR.ImageDrawable(stopButtonImg, 0.2, {
			onClick: function stopButtonClicked()
			{
				ceritamonyet.stop();
				enabled: false;
			},
			offsetX: 0.3,
			offsetY: -0.2,
		});

		var overlayOne17 = new AR.ImageDrawable(imgOne17, 0.3, {
			offsetX: -0.2,
			offsetY: 0.5
		});

		var pageSeventeen = new AR.Trackable2DObject(this.tracker, "ceritamonyet", {
			drawables: {
				cam: [overlayOne17, moreButton17, playButton17, stopButton17, sparkles]
			},
			enableExtendedTracking: true,
			onExtendedTrackingQualityChanged: function (targetName, oldTrackingQuality, newTrackingQuality)
			{
				var backgroundColor;
				var trackingQualityText;

				if ( -1 == newTrackingQuality ) {
					backgroundColor = '#FF3420';
					trackingQualityText = 'Bad';
				} else if ( 0 == newTrackingQuality ) {
					backgroundColor = '#FFD900';
					trackingQualityText = 'Average';
				} else {
					backgroundColor = '#6BFF00';
					trackingQualityText = 'Good';
				}
				var cssDivInstructions = " style='display: table-cell;vertical-align: middle; text-align: middle; width: 50%; padding-right: 15px;'";
				var messageBox = document.getElementById('loadingMessage');
				messageBox.style.backgroundColor = backgroundColor;
				messageBox.innerHTML = "<div" + cssDivInstructions + ">Tracking Quality: " + trackingQualityText + "</div>";
				messageBox.style.display = 'block';
			},onExitFieldOfVision: function onExitFieldOfVisionFn() {ceritamonyet.stop();}
		});

        //variable list section 18===========================================================================================================================
		var moreButton18 = new AR.ImageDrawable(moreButtonImg, 0.25, {
			onClick: function moreButtonClicked()
			{
				AR.context.openInBrowser("https://googledrive.com/host/0BxQMyJVlV8MWRFdqblJhSTZIVGc/index18.html");
			},
			offsetX: -0.2,
			offsetY: -0.5,
		});

		var playButton18 = new AR.ImageDrawable(playButtonImg, 0.2, {
			onClick: function playButtonClicked()
			{
				dewadalam.stop();
				dewadalam.play();
				enabled: false;
			},
			offsetX: 0.3,
			offsetY: -0.5,
		});

		var stopButton18 = new AR.ImageDrawable(stopButtonImg, 0.2, {
			onClick: function stopButtonClicked()
			{
				dewadalam.stop();
				enabled: false;
			},
			offsetX: 0.3,
			offsetY: -0.2,
		});

		var overlayOne18 = new AR.ImageDrawable(imgOne18, 0.3, {
			offsetX: -0.2,
			offsetY: 0.5
		});

		var pageEighteen = new AR.Trackable2DObject(this.tracker, "dewadalam", {
			drawables: {
				cam: [overlayOne18, moreButton18, playButton18, stopButton18, sparkles]
			},
			enableExtendedTracking: true,
			onExtendedTrackingQualityChanged: function (targetName, oldTrackingQuality, newTrackingQuality)
			{
				var backgroundColor;
				var trackingQualityText;

				if ( -1 == newTrackingQuality ) {
					backgroundColor = '#FF3420';
					trackingQualityText = 'Bad';
				} else if ( 0 == newTrackingQuality ) {
					backgroundColor = '#FFD900';
					trackingQualityText = 'Average';
				} else {
					backgroundColor = '#6BFF00';
					trackingQualityText = 'Good';
				}
				var cssDivInstructions = " style='display: table-cell;vertical-align: middle; text-align: middle; width: 50%; padding-right: 15px;'";
				var messageBox = document.getElementById('loadingMessage');
				messageBox.style.backgroundColor = backgroundColor;
				messageBox.innerHTML = "<div" + cssDivInstructions + ">Tracking Quality: " + trackingQualityText + "</div>";
				messageBox.style.display = 'block';
			},onExitFieldOfVision: function onExitFieldOfVisionFn() {dewadalam.stop();}
		});

        //variable list section 19===========================================================================================================================
		var moreButton19 = new AR.ImageDrawable(moreButtonImg, 0.25, {
			onClick: function moreButtonClicked()
			{
				AR.context.openInBrowser("https://googledrive.com/host/0BxQMyJVlV8MWRFdqblJhSTZIVGc/index19.html");
			},
			offsetX: -0.2,
			offsetY: -0.5,
		});

		var playButton19 = new AR.ImageDrawable(playButtonImg, 0.2, {
			onClick: function playButtonClicked()
			{
				bersaudara.stop();
				bersaudara.play();
				enabled: false;
			},
			offsetX: 0.3,
			offsetY: -0.5,
		});

		var stopButton19 = new AR.ImageDrawable(stopButtonImg, 0.2, {
			onClick: function stopButtonClicked()
			{
				bersaudara.stop();
				enabled: false;
			},
			offsetX: 0.3,
			offsetY: -0.2,
		});

		var overlayOne19 = new AR.ImageDrawable(imgOne19, 0.3, {
			offsetX: -0.2,
			offsetY: 0.5
		});

		var pageNineteen = new AR.Trackable2DObject(this.tracker, "bersaudara", {
			drawables: {
				cam: [overlayOne19, moreButton19, playButton19, stopButton19, sparkles]
			},
			enableExtendedTracking: true,
			onExtendedTrackingQualityChanged: function (targetName, oldTrackingQuality, newTrackingQuality)
			{
				var backgroundColor;
				var trackingQualityText;

				if ( -1 == newTrackingQuality ) {
					backgroundColor = '#FF3420';
					trackingQualityText = 'Bad';
				} else if ( 0 == newTrackingQuality ) {
					backgroundColor = '#FFD900';
					trackingQualityText = 'Average';
				} else {
					backgroundColor = '#6BFF00';
					trackingQualityText = 'Good';
				}
				var cssDivInstructions = " style='display: table-cell;vertical-align: middle; text-align: middle; width: 50%; padding-right: 15px;'";
				var messageBox = document.getElementById('loadingMessage');
				messageBox.style.backgroundColor = backgroundColor;
				messageBox.innerHTML = "<div" + cssDivInstructions + ">Tracking Quality: " + trackingQualityText + "</div>";
				messageBox.style.display = 'block';
			},onExitFieldOfVision: function onExitFieldOfVisionFn() {bersaudara.stop();}
		});

        //variable list section 20===========================================================================================================================
		var moreButton20 = new AR.ImageDrawable(moreButtonImg, 0.25, {
			onClick: function moreButtonClicked()
			{
				AR.context.openInBrowser("https://googledrive.com/host/0BxQMyJVlV8MWRFdqblJhSTZIVGc/index20.html");
			},
			offsetX: -0.2,
			offsetY: -0.5,
		});

		var playButton20 = new AR.ImageDrawable(playButtonImg, 0.2, {
			onClick: function playButtonClicked()
			{
				burunganeh.stop();
				burunganeh.play();
				enabled: false;
			},
			offsetX: 0.3,
			offsetY: -0.5,
		});

		var stopButton20 = new AR.ImageDrawable(stopButtonImg, 0.2, {
			onClick: function stopButtonClicked()
			{
				burunganeh.stop();
				enabled: false;
			},
			offsetX: 0.3,
			offsetY: -0.2,
		});

		var overlayOne20 = new AR.ImageDrawable(imgOne20, 0.3, {
			offsetX: -0.2,
			offsetY: 0.5
		});

		var pageTwenty = new AR.Trackable2DObject(this.tracker, "burunganeh", {
			drawables: {
				cam: [overlayOne20, moreButton20, playButton20, stopButton20, sparkles]
			},
			enableExtendedTracking: true,
			onExtendedTrackingQualityChanged: function (targetName, oldTrackingQuality, newTrackingQuality)
			{
				var backgroundColor;
				var trackingQualityText;

				if ( -1 == newTrackingQuality ) {
					backgroundColor = '#FF3420';
					trackingQualityText = 'Bad';
				} else if ( 0 == newTrackingQuality ) {
					backgroundColor = '#FFD900';
					trackingQualityText = 'Average';
				} else {
					backgroundColor = '#6BFF00';
					trackingQualityText = 'Good';
				}
				var cssDivInstructions = " style='display: table-cell;vertical-align: middle; text-align: middle; width: 50%; padding-right: 15px;'";
				var messageBox = document.getElementById('loadingMessage');
				messageBox.style.backgroundColor = backgroundColor;
				messageBox.innerHTML = "<div" + cssDivInstructions + ">Tracking Quality: " + trackingQualityText + "</div>";
				messageBox.style.display = 'block';
			},onExitFieldOfVision: function onExitFieldOfVisionFn() {burunganeh.stop();}
		});

        //variable list section 21===========================================================================================================================
		var moreButton21 = new AR.ImageDrawable(moreButtonImg, 0.25, {
			onClick: function moreButtonClicked()
			{
				AR.context.openInBrowser("https://googledrive.com/host/0BxQMyJVlV8MWRFdqblJhSTZIVGc/index21.html");
			},
			offsetX: -0.2,
			offsetY: -0.5,
		});

		var playButton21 = new AR.ImageDrawable(playButtonImg, 0.2, {
			onClick: function playButtonClicked()
			{
				anakdewa.stop();
				anakdewa.play();
				enabled: false;
			},
			offsetX: 0.3,
			offsetY: -0.5,
		});

		var stopButton21 = new AR.ImageDrawable(stopButtonImg, 0.2, {
			onClick: function stopButtonClicked()
			{
				anakdewa.stop();
				enabled: false;
			},
			offsetX: 0.3,
			offsetY: -0.2,
		});

		var overlayOne21 = new AR.ImageDrawable(imgOne21, 0.3, {
			offsetX: -0.2,
			offsetY: 0.5
		});

		var pageTwentyone = new AR.Trackable2DObject(this.tracker, "anakdewa", {
			drawables: {
				cam: [overlayOne21, moreButton21, playButton21, stopButton21, sparkles]
			},
			enableExtendedTracking: true,
			onExtendedTrackingQualityChanged: function (targetName, oldTrackingQuality, newTrackingQuality)
			{
				var backgroundColor;
				var trackingQualityText;

				if ( -1 == newTrackingQuality ) {
					backgroundColor = '#FF3420';
					trackingQualityText = 'Bad';
				} else if ( 0 == newTrackingQuality ) {
					backgroundColor = '#FFD900';
					trackingQualityText = 'Average';
				} else {
					backgroundColor = '#6BFF00';
					trackingQualityText = 'Good';
				}
				var cssDivInstructions = " style='display: table-cell;vertical-align: middle; text-align: middle; width: 50%; padding-right: 15px;'";
				var messageBox = document.getElementById('loadingMessage');
				messageBox.style.backgroundColor = backgroundColor;
				messageBox.innerHTML = "<div" + cssDivInstructions + ">Tracking Quality: " + trackingQualityText + "</div>";
				messageBox.style.display = 'block';
			},onExitFieldOfVision: function onExitFieldOfVisionFn() {anakdewa.stop();}
		});

        //variable list section 22===========================================================================================================================
		var moreButton22 = new AR.ImageDrawable(moreButtonImg, 0.25, {
			onClick: function moreButtonClicked()
			{
				AR.context.openInBrowser("https://googledrive.com/host/0BxQMyJVlV8MWRFdqblJhSTZIVGc/index22.html");
			},
			offsetX: -0.2,
			offsetY: -0.5,
		});

		var playButton22 = new AR.ImageDrawable(playButtonImg, 0.2, {
			onClick: function playButtonClicked()
			{
				bangau.stop();
				bangau.play();
				enabled: false;
			},
			offsetX: 0.3,
			offsetY: -0.5,
		});

		var stopButton22 = new AR.ImageDrawable(stopButtonImg, 0.2, {
			onClick: function stopButtonClicked()
			{
				bangau.stop();
				enabled: false;
			},
			offsetX: 0.3,
			offsetY: -0.2,
		});

		var overlayOne22 = new AR.ImageDrawable(imgOne22, 0.3, {
			offsetX: -0.2,
			offsetY: 0.5
		});

		var pageTwentytwo = new AR.Trackable2DObject(this.tracker, "bangau", {
			drawables: {
				cam: [overlayOne22, moreButton22, playButton22, stopButton22, sparkles]
			},
			enableExtendedTracking: true,
			onExtendedTrackingQualityChanged: function (targetName, oldTrackingQuality, newTrackingQuality)
			{
				var backgroundColor;
				var trackingQualityText;

				if ( -1 == newTrackingQuality ) {
					backgroundColor = '#FF3420';
					trackingQualityText = 'Bad';
				} else if ( 0 == newTrackingQuality ) {
					backgroundColor = '#FFD900';
					trackingQualityText = 'Average';
				} else {
					backgroundColor = '#6BFF00';
					trackingQualityText = 'Good';
				}
				var cssDivInstructions = " style='display: table-cell;vertical-align: middle; text-align: middle; width: 50%; padding-right: 15px;'";
				var messageBox = document.getElementById('loadingMessage');
				messageBox.style.backgroundColor = backgroundColor;
				messageBox.innerHTML = "<div" + cssDivInstructions + ">Tracking Quality: " + trackingQualityText + "</div>";
				messageBox.style.display = 'block';
			},onExitFieldOfVision: function onExitFieldOfVisionFn() {bangau.stop();}
		});

        //variable list section 23===========================================================================================================================
		var moreButton23 = new AR.ImageDrawable(moreButtonImg, 0.25, {
			onClick: function moreButtonClicked()
			{
				AR.context.openInBrowser("https://googledrive.com/host/0BxQMyJVlV8MWRFdqblJhSTZIVGc/index23.html");
			},
			offsetX: -0.2,
			offsetY: -0.5,
		});

		var playButton23 = new AR.ImageDrawable(playButtonImg, 0.2, {
			onClick: function playButtonClicked()
			{
				alurdewa.stop();
				alurdewa.play();
				enabled: false;
			},
			offsetX: 0.3,
			offsetY: -0.5,
		});

		var stopButton23 = new AR.ImageDrawable(stopButtonImg, 0.2, {
			onClick: function stopButtonClicked()
			{
				alurdewa.stop();
				enabled: false;
			},
			offsetX: 0.3,
			offsetY: -0.2,
		});

		var overlayOne23 = new AR.ImageDrawable(imgOne23, 0.3, {
			offsetX: -0.2,
			offsetY: 0.5
		});

		var pageTwentythree = new AR.Trackable2DObject(this.tracker, "alurdewa", {
			drawables: {
				cam: [overlayOne23, moreButton23, playButton23, stopButton23, sparkles]
			},
			enableExtendedTracking: true,
			onExtendedTrackingQualityChanged: function (targetName, oldTrackingQuality, newTrackingQuality)
			{
				var backgroundColor;
				var trackingQualityText;

				if ( -1 == newTrackingQuality ) {
					backgroundColor = '#FF3420';
					trackingQualityText = 'Bad';
				} else if ( 0 == newTrackingQuality ) {
					backgroundColor = '#FFD900';
					trackingQualityText = 'Average';
				} else {
					backgroundColor = '#6BFF00';
					trackingQualityText = 'Good';
				}
				var cssDivInstructions = " style='display: table-cell;vertical-align: middle; text-align: middle; width: 50%; padding-right: 15px;'";
				var messageBox = document.getElementById('loadingMessage');
				messageBox.style.backgroundColor = backgroundColor;
				messageBox.innerHTML = "<div" + cssDivInstructions + ">Tracking Quality: " + trackingQualityText + "</div>";
				messageBox.style.display = 'block';
			},onExitFieldOfVision: function onExitFieldOfVisionFn() {alurdewa.stop();}
		});

		//variable list section 24-==========================================================================================================================
		var moreButton24 = new AR.ImageDrawable(moreButtonImg, 0.25, {
			onClick: function moreButtonClicked()
			{
				AR.context.openInBrowser("https://googledrive.com/host/0BxQMyJVlV8MWRFdqblJhSTZIVGc/index24.html");
			},
			offsetX: -0.2,
			offsetY: -0.5,
		});

		var playButton24 = new AR.ImageDrawable(playButtonImg, 0.2, {
			onClick: function playButtonClicked()
			{
				sumo.stop();
				sumo.play();
				enabled: false;
			},
			offsetX: 0.3,
			offsetY: -0.5,
		});

		var stopButton24 = new AR.ImageDrawable(stopButtonImg, 0.2, {
			onClick: function stopButtonClicked()
			{
				sumo.stop();
				enabled: false;
			},
			offsetX: 0.3,
			offsetY: -0.2,
		});

		var overlayOne24 = new AR.ImageDrawable(imgOne24, 0.3, {
			offsetX: -0.2,
			offsetY: 0.5
		});

		var pageTwentyfour = new AR.Trackable2DObject(this.tracker, "sumo", {
			drawables: {
				cam: [overlayOne24, moreButton24, playButton24, stopButton24, sparkles]
			},
			enableExtendedTracking: true,
			onExtendedTrackingQualityChanged: function (targetName, oldTrackingQuality, newTrackingQuality)
			{
				var backgroundColor;
				var trackingQualityText;

				if ( -1 == newTrackingQuality ) {
					backgroundColor = '#FF3420';
					trackingQualityText = 'Bad';
				} else if ( 0 == newTrackingQuality ) {
					backgroundColor = '#FFD900';
					trackingQualityText = 'Average';
				} else {
					backgroundColor = '#6BFF00';
					trackingQualityText = 'Good';
				}
				var cssDivInstructions = " style='display: table-cell;vertical-align: middle; text-align: middle; width: 50%; padding-right: 15px;'";
				var messageBox = document.getElementById('loadingMessage');
				messageBox.style.backgroundColor = backgroundColor;
				messageBox.innerHTML = "<div" + cssDivInstructions + ">Tracking Quality: " + trackingQualityText + "</div>";
				messageBox.style.display = 'block';
			},onExitFieldOfVision: function onExitFieldOfVisionFn() {sumo.stop();}
		});

		//variable list section 25===========================================================================================================================
		var moreButton25 = new AR.ImageDrawable(moreButtonImg, 0.25, {
			onClick: function moreButtonClicked()
			{
				AR.context.openInBrowser("https://googledrive.com/host/0BxQMyJVlV8MWRFdqblJhSTZIVGc/index.html");
			},
			offsetX: 0,
			offsetY: 0.4,
		});

		var pageTwentyfive = new AR.Trackable2DObject(this.tracker, "papanresmi", {
			drawables: {
				cam: [video, moreButton25]
			},
			onEnterFieldOfVision: function onEnterFieldOfVisionFn() {
				if (video.playing) {
					video.resume();
				}
			},
			onExitFieldOfVision: function onExitFieldOfVisionFn() {
				if (video.playing) {
					video.pause();
				}
			}
		});

	},
	worldLoaded: function worldLoadedFn() {
		var cssDivLeft = " style='display: table-cell;vertical-align: middle; text-align: right; width: 50%; padding-right: 15px;'";
		var cssDivRight = " style='display: table-cell;vertical-align: middle; text-align: left;'";
		document.getElementById('loadingMessage').innerHTML ="<div" + cssDivRight + ">Scan any Object which listed in Gallery!</div>";

		// Remove Scan target message after 10 sec.
		setTimeout(function() {
			var e = document.getElementById('loadingMessage');
			e.parentElement.removeChild(e);
		}, 10000);
	}
};

World.init();