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



})();

function asd(a, id)
{
    if (a === 1) {
        document.getElementById(id).style.display = "block";
        $('#hide').hide();
    } else {
        $("#" + id).hide();
        $("#hide").show();


    }
}

