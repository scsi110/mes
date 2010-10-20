var QCD = QCD || {};
QCD.components = QCD.components || {};
QCD.components.elements = QCD.components.elements || {};

QCD.components.elements.CheckBox = function(_element, _mainController) {
	$.extend(this, new QCD.components.Component(_element, _mainController));

	var mainController = _mainController;
	
	var element = _element;
	
	var input = $("#"+element.attr('id')+"_input");
	
	var messagesSpan = $("#"+element.attr('id')+"_messagesSpan");
	
	this.getComponentValue = function() {
		if (input.attr('checked')) {
			return { value: "1" };
		}
		return { value: "0" };
	}
	
	this.setComponentValue = function(value) {
		insertValue(value.value);
	}
	
	this.setComponentState = function(state) {
		insertValue(state.value);
	}
	
	function insertValue(value) {
		if (value == 1) {
			input.attr('checked', true);
		} else {
			input.attr('checked', false);
		}
	}
	
	this.setComponentEnabled = function(isEnabled) {
		if (isEnabled) {
			input.removeAttr('disabled');
		} else {
			input.attr('disabled', 'true');
		}
	}
	
	this.setMessages = function(messages) {
		var message = "";
		for (var i in messages.error) {
			if (message != "") {
				message += ", ";
			}
			message += messages.error[i];
		}
		for (var i in messages.info) {
			if (message != "") {
				message += ", ";
			}
			message += messages.info[i];
		}
		for (var i in messages.success) {
			if (message != "") {
				message += ", ";
			}
			message += messages.success[i];
		}
		messagesSpan.html(message);
	}
	
	this.setComponentLoading = function(isLoadingVisible) {
	}
}