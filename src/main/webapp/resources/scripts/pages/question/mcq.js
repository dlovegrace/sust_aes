function submitMCQ() {
	var url = '/sustaes/question/create';
	var options = [];
	var i = 0;
	while (true) {
		if (document.getElementById('mcq-opt-' + i) == null)
			break;
		var opt = {};
		opt["index"] = i;
		opt["text"] = document.getElementById('mcq-opt-' + i + '-text').value;
		opt["answer"] = document.getElementById('mcq-opt-' + i + '-answer').checked == true ? true
				: false;
		options.push(opt);
		i++;
	}
	var question = {};
	question['questionText'] = document.getElementById('mcq-question-text').value;
	question['questionMarks'] = document.getElementById('mcq-marks').value;
	question['requiredTime'] = document.getElementById('mcq-time').value;
	question['courseId.courseId'] = document.getElementById('courseId').value;
	question['questionType'] = "MCQ";
	question['questionBody'] = JSON.stringify(options);
	console.log(question);
	$.ajax({
		method : "POST",
		url : url,
		data : question
	}).success(
			function(msg) {
				console.log('SUCCESS MCQ ' + msg);
				if (msg != null) {
					console.log("Question [questionId=" + msg['questionId']
							+ ", questionBody=" + msg['questionBody']);

					$('#success-modal').modal('show');
					appendQuestion(msg);
				} else {
					$('#error-modal').modal('show');
				}
			}).error(function(msg) {
		$('#error-modal').modal('show');
	});
}
