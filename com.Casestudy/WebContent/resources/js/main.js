(function() {

			  "use strict";

			  var toggles = document.querySelectorAll("#toggle-btn");
			  // var x = document.getElementById("#toggle-btn").previousSibling.innerHTML;

			  for (var i = toggles.length - 1; i >= 0; i--) {
			    var toggle = toggles[i];
			    toggleHandler(toggle);
			  };

			  function toggleHandler(toggle) {
			    toggle.addEventListener( "click", function(e) {
			      e.preventDefault();
			      (this.classList.contains("active") === true) ? this.classList.remove("active") : this.classList.add("active");
			    });
			  }

			})();

			(function() {

			  // "use strict";

			  // var toggles = document.getElementById("#toggle-btn").innerHTML;
			  // var x = document.getElementById("#toggle-btn").previousSibling.innerHTML;
			  // console.log(toggles);
			  var img1 = $("#toggle-btn").closest("a").prev().find("img.navlogo1");
			  var img2 = $("#toggle-btn").closest("a").prev().find("img.navlogo2");
			 	$("#toggle-btn").click(function(){

					$( img1).toggle();
					$( img2).toggle();
					// $("nav.side-navbar").css({"min-width": "90px", "max-width": "90px", "text-align": "center", "padding": "10px", "font-size": ".5rem"});
					$("nav.side-navbar").toggleClass("shrinked");
					$("div.content-inner").toggleClass("active");
			   });


			 // 	$(".nav .side-navbar").on("click", function(){
				//    $(".nav").find(".active").removeClass("active");
				//    $(this).addClass("active");
				// });

			})();
			
			
