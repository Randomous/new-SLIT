/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




(function () {


    var script = document.createElement('script');
    script.src = 'http://code.jquery.com/jquery-latest.min.js';
    script.type = 'text/javascript';
    document.getElementsByTagName('head')[0].appendChild(script);
    var tag = document.createElement('script');
        tag.src = "https://www.youtube.com/player_api";
        var firstScriptTag = document.getElementsByTagName('script')[0];
        firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);


})();

function asd(a, id)
{
    if (a === 1) {
        document.getElementById(id).style.display = "block";
        $('#hide' + id).hide();
    } else {
        $("#" + id).hide();
        $("#hide" + id).show();


    }
}


/* Set the width of the side navigation to 250px and the left margin of the page content to 250px */
function openNav() {
    document.getElementById("mySidenav").style.width = "250px";
    document.getElementById("main").style.marginLeft = "250px";
}

/* Set the width of the side navigation to 0 and the left margin of the page content to 0 */
function closeNav() {
    document.getElementById("mySidenav").style.width = "0";
    document.getElementById("main").style.marginLeft = "0";
} 

function listSize(list) {
        var ul = document.getElementById(list);
	var i=0, itemCount =0;
	while(ul.getElementsByTagName('li') [i++]) itemCount++;
        var text = "Det er " + itemCount + " leveringer i kø";
        
        document.getElementById("listCount").innerHTML = text;
    //return $("#" + setList + " li").length;
}
function youtubeEmbed(vidID, vidText) {
    var position = document.documentElement.innerHTML.indexOf('https://youtu.be');
    if (position !== 0) {
//        alert(vidText);

    document.getElementById(vidText).innerHTML = "WORKS";

    } else {
        console.log("NO TREFF");
            document.getElementById("vidText").innerHTML = "FACK!!!!!!!!!!!";
    }
    
}
function youtubeID(url) {
//    alert(url);
var videoid = url.match(/(?:https?:\/{2})?(?:w{3}\.)?youtu(?:be)?\.(?:com|be)(?:\/watch\?v=|\/)([^\s&]+)/);
if(videoid !== null) {
   console.log("video id = " + videoid[1]);
} else { 
    console.log("The youtube url is not valid.");
}
return videoid[1];
}
function youtubePlayer(ytID, playerID) {
     // Load the IFrame Player API code asynchronously.
//  var tag = document.createElement('script');
//  tag.src = "https://www.youtube.com/player_api";
//  var firstScriptTag = document.getElementsByTagName('script')[0];
//  firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);
//
//  // Replace the 'ytplayer' element with an <iframe> and
//  // YouTube player after the API code downloads.
//  var player;
//  function onYouTubePlayerAPIReady() {
//    player = new YT.Player('ytplayer', {
//      height: '360',
//      width: '640',
//      videoId: 'M7lc1UVf-VE'
//    });
//  }
//                            var div = document.getElementById(playerID);
//                            // With old JS syntax
////                            div.id = "ytplayer" + new Date().getTime().toString();
////                            alert(div.id);
////                          ##Looking good but needs some int change
//                            var datestr = new Date().getTime().toString(), randomstr = Math.random().toString(); 
//                            var bigString = 'id' + datestr + randomstr;
                               var div = document.getElementById(playerID);
                               var bigString = getUniqueId(div);
                               div.id = bigString;
//                            div.id = bigString;
//                            alert(div.id);
                            var ytStand = "https://www.youtube.com/embed/";
                            var newLink = ytStand + ytID;
                               document.getElementById(div.id).src = newLink;
      }
function getUniqueId(id) {
    
                            // With old JS syntax
//                            div.id = "ytplayer" + new Date().getTime().toString();
//                            alert(div.id);
//                          ##Looking good but needs some int change
                            var datestr = new Date().getTime().toString(), randomstr = Math.random().toString(); 
                            var bigString = id + datestr + randomstr;
                            
                            return bigString;
}