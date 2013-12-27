var topicOptions = {
	init : function() {
		topicOptions.initEvent();
	},
	initEvent : function() {
		$('.container').delegate('button[id="favour"]', 'click', function() {
			var $button = $(this);
			var topicId = $button.siblings('input[name="topicId"]').val();

			$.post('favour/' + topicId, function(data) {
				data = $.parseJSON(data);
				if (data.rs) {
					var option = data.option;
					var $span = $button.find('span').remove();
					var v = $button.text();
					v = parseInt(v);
					var o = parseInt(option);
					v = v + o;
					$button.html('');
					$button.append($span);
					$button.append(v);
					console.log(v);
				}

			});
		});

	}

};

var home_content = {
	topics : null,
	init : function(topics) {
		this.topics = topics;
		this.fixContent();
	},
	fixContent : function() {
		var topics = this.topics;
		var html = [];
		$
				.each(
						topics,
						function(index, obj) {
							var img = "";
							var text = "";
							var topic = obj.topic;
							$.each($.parseJSON(topic.topicContent), function(i, content) {
								if (content.type == '1') {
									img = content.content;
									img = [ '<img src="resources/image/', img,
											'" alt="图片">' ].join('');
								} else {
									text = content.content;
								}
							});
							var div = [
									'<div class="col-sm-6 col-md-8">',
									'<div class="thumbnail">',
									'<div class="media">',
									'  <a class="pull-left" href="#">',
									'    <img class="media-object" src="http://www.qiushibaike.com/static/images/thumb/missing.png" alt="头像">',
									'  </a>',
									'  <div class="media-body">',
									'    <h6 class="media-heading">',
									obj.user.userName,
									'</h6>',
									'  </div>',
									'</div>',
									'<div class="caption">',
									'<p>',
									text,
									'</p>',

									'</div>',
									img,
									'<div style="float: right;"><div  style="float: right;">',

									'<input type="hidden" name="topicId" value="',
									topic.topicId,
									'" />',
									'<button type="button" class="btn btn-default btn-sm" id="favour">',
									'<span class="glyphicon glyphicon-thumbs-up"></span>',
									topic.favourCount,
									'</button>',
									'<button type="button" class="btn btn-default btn-sm" id="hate">',
									'<span class="glyphicon glyphicon-thumbs-down"></span>',
									topic.hateCount,
									'</button>',
									'<button type="button" class="btn btn-default btn-sm" id="share">',
									'<span class="glyphicon glyphicon-share-alt"></span> ',
									topic.shareCount,
									'</button>',
									'<button type="button" class="btn btn-default btn-sm" id="comment">',
									'<span class="glyphicon glyphicon-comment"></span>  ',
									topic.commentCount, '</button>',
									'</div></div>', '</div>',

									'</div>' ];
							html.push(div.join(''));
						});
		$('.row').html(html.join(''));
	}

};

$(document).ready(function() {
	topicOptions.init();
});