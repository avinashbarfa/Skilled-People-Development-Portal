//Webiste loader

	var myVar;

	function WebsiteLoader() {
	    myVar = setTimeout(showPage, 0005);
	}

	function showPage() {
	  document.getElementById("loader").style.display = "none";
	  document.getElementById("myDiv").style.display = "block";
	}

	function myNavigation() {
	    var x = document.getElementById("myNavmedium");
	    if (x.className === "nav-medium") {
	        x.className += " responsive";
	    } else {
	        x.className = "nav-medium";
	    }

	    // Get the modal
		var modal = document.getElementById('id01');

		// When the user clicks anywhere outside of the modal, close it
		window.onclick = function(event) {
	    	if (event.target == modal) {
	        	modal.style.display = "none";
	    	}
		}
	}



// tab-content-viewer
	function openCategory(evt, optionTag) {
    // Declare all variables
    var i, tabcontent, tablinks;

    // Get all elements with class="tabcontent" and hide them
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }

    // Get all elements with class="tablinks" and remove the class "active"
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }

    // Show the current tab, and add an "active" class to the button that opened the tab
    document.getElementById(optionTag).style.display = "block";
    evt.currentTarget.className += " active";
	}

	// Get the element with id="defaultOpen" and click on it
	document.getElementById("defaultOpen").click();


