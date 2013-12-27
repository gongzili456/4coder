var imageUploader = {
	upload : function($uploder, url) {
		$uploder.fileupload({
			url : url,
			done : function(e, result) {
				console.log(JSON.stringify(result.result));
			}
		});
	}
};