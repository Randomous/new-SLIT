/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




(function () {

//    script.src = 'http://code.jquery.com/jquery-latest.min.js';
    var script = document.createElement('script');
    script.src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js";
    script.type = 'text/javascript';
//    var script2 = document.createElement('script');
//    script2.src="JS/Repo.js-master/repo.js";
//    script2.type = 'text/javascript';

//    document.getElementsByTagName('head')[0].appendChild(script);
//    var tag = document.createElement('script');
//        tag.src = "https://www.youtube.com/player_api";
//        var firstScriptTag = document.getElementsByTagName('script')[0];
//        firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);


})();
// $(document).ready(function () {
//  var repo = document.createElement('repo');
//            repo.src="JS/Repo.js-master/repo.min.js";
//            repo.type = 'text/javascript';
//});

/* Function for showing and hiding a div enclosed within a button
 * Set display style with 1 or any other number
 * Recommended 1 or 2
 * @param {number} a is the check identifier
 * @param {string} id is the id of the div   */
function asd(a, id) {
  //your code here

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

  //your code here

/* Count the items in a given list and return the count with text*/
function listSize(list) {

        var ul = document.getElementById(list);
	var i=0, itemCount =0;
	while(ul.getElementsByTagName('li') [i++]) itemCount++;
        var text = "Det er " + itemCount + " leveringer i kø";
        
        document.getElementById("listCount").innerHTML = text;
    //return $("#" + setList + " li").length;
}

/* Function for checking if youtube link is present */
function youtubeEmbed(vidID, vidText) {
    var position = document.documentElement.innerHTML.indexOf('https://youtu.be');
    if (position !== 0) {

    document.getElementById(vidText).innerHTML = "WORKS";

    } else {
        console.log("NO TREFF");
            document.getElementById("vidText").innerHTML = "FACK!!!!!!!!!!!";
    }
    
}
/* Fetches the youtube ID of video from a full youtube link
 * any youtube link format is supported
 * returns the ID as standalone variable */
function youtubeID(url) {
var videoid = url.match(/(?:https?:\/{2})?(?:w{3}\.)?youtu(?:be)?\.(?:com|be)(?:\/watch\?v=|\/)([^\s&]+)/);
if(videoid !== null) {
   console.log("video id = " + videoid[1]);
} else { 
    console.log("The youtube url is not valid.");
}
return videoid[1];
}
/* Function for setting and updating an iFrame with the given youtube ID
 * Automatically sets embeded video
 * @param {string} ytID is the ID of youtube video to be set
 * @param {string} is the iFrame to be targeted and set with the ytID  */
function youtubePlayer(ytID, playerID) {

    var div = document.getElementById(playerID);
    var bigString = getUniqueId(div);
    div.id = bigString;

    var ytStand = "https://www.youtube.com/embed/";
    var newLink = ytStand + ytID;
        document.getElementById(div.id).src = newLink;
      }
/* Function for setting and updating an iFrame with the given youtube ID
 * Automatically sets embeded video
 * @param {string} ytID is the ID of youtube video to be set
 * @param {string} is the iFrame to be targeted and set with the ytID  */
function idSetter(setID) {
    
    var div = document.getElementById(setID);
    var bigString = getUniqueId(setID);
    div.id = bigString;
    return div.id;

      }
/* Generates a unique id for multiple id's inside a loop
 * @param {string} id is the start id that will be build upon with time and math rand
 * @return bigString is the complete unique identifier */
function getUniqueId(id) {
    
    var datestr = new Date().getTime().toString(), randomstr = Math.random().toString(); 
    var bigString = id + datestr + randomstr;

    return bigString;
}
function setGitLink(id, link) {
     var div = document.getElementById(id);
        document.getElementById(div.id).href = link;
}
//function setRepo(repoID) {
//    $(document).ready(function () {
//    $('#' + repoID).repo({ user: 'twitter', name: 'bootstrap' });
////    $('#' + repoID).repo({ user: 'CastleDev', name: 'UiA-SLIT'});
//});
//    
//}