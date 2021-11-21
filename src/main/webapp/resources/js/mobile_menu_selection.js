function bindChangeOnMobileMenu() { 
	var loc = document.location.href; 
	var scripts = document.getElementsByTagName('script');
	var parentDiv = scripts[scripts.length - 1].parentNode;
	var parentNode;
	var selectTag;
	var sibling;
	var href;
	for(var i=0; i<parentDiv.childNodes.length; i++) { 
		sibling = parentDiv.childNodes[i];

		if(sibling.tagName == 'SELECT') { 
			selectTag = sibling;

			for (var i = 0; i < selectTag.options.length; i++) {
				shref = selectTag.options[i].value;
				var link = document.createElement("a");
    			link.href = shref;
    			href = link.href;
				if (loc == href && selectTag.selectedIndex != i) {
					selectTag.options[i].selected = true;
					break;
				}
			}
		}
	}
	
	if(selectTag) { 
		mobileMenuChange(selectTag);
	}

}

function mobileMenuChange(selectTag){
	selectTag.onchange = function(){
		location.assign(selectTag.options[selectTag.selectedIndex].value);
	}
}

bindChangeOnMobileMenu();