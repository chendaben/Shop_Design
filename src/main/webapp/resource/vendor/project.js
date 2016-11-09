$(function(){
   $('button.modifySelfMessage').click(function () {
       $('.informationList table tr td input, .informationList table tr td select').removeClass('preSelect').removeAttr('disabled');
   });

});