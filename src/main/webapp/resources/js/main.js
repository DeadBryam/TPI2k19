document.addEventListener('DOMContentLoaded', function() {
    var elems = document.querySelectorAll('.sidenav');
    var instances = M.Sidenav.init(elems);
  });

$(document).ready(function(){
    $('.modal').modal({
        dismissible: false,
        startingTop: '0%'
    });
  });