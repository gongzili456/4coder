package cn.gongzili.topic.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.InputStreamBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import cn.gongzili.topic.bean.Topic;
import cn.gongzili.topic.bean.TopicOption;
import cn.gongzili.topic.service.TopicService;
import cn.gongzili.user.bean.User;
import cn.gongzili.user.service.UserService;
import cn.gongzili.utils.PropertyUtils;

@Controller
public class TopicController {

	@Autowired
	TopicService topicService;
	@Autowired
	UserService userService;

	@RequestMapping("/publishPage")
	public ModelAndView publishPage(HttpServletRequest request) {
		return new ModelAndView("topic/topic_publish");
	}

	@RequestMapping("/publish")
	public ModelAndView publish(HttpServletRequest request, Model model,
			@RequestParam MultipartFile image) {
		JSONArray array = new JSONArray();
		String path = saveImage(image);
		if (path != null && !path.equals("")) {
			JSONObject json = new JSONObject();
			json.put("type", "1");
			json.put("content", path);
			array.add(json);
		}

		String title = request.getParameter("title");
		String content = request.getParameter("content");
		Topic t = new Topic();
		t.setTopicTitle(title);

		JSONObject json = new JSONObject();
		json.put("type", "0");
		json.put("content", content);
		array.add(json);

		t.setTopicContent(array.toString());

		Subject subject = SecurityUtils.getSubject();
		Object p = subject.getPrincipal();
		User u = userService.findUserByEmail(p.toString());
		t.setTopicUserId(u.getUserId());
		t.setTopicStatus(Topic.TOPIC_STATUS_NORMAL);
		t.setTopicDate(System.currentTimeMillis());
		topicService.insertTopic(t);
		return new ModelAndView("topic/topic_publish");
	}

	@RequestMapping("/topicList")
	public ModelAndView list(Model model) {
		List<Map<String, Object>> topics = topicService.queryTopicList();
		model.addAttribute("topics", JSONArray.fromObject(topics));
		return new ModelAndView("topic/topic_list");
	}

	@RequestMapping("/favour/{topicId}")
	@ResponseBody
	public String favour(@PathVariable long topicId,
			HttpServletRequest request, Model model) {
		Session session = SecurityUtils.getSubject().getSession();
		User u = (User) session.getAttribute(User.SESSION_USER);
		boolean rs = false;
		if (topicService.queryTopicOption(topicId, u.getUserId())) {
			rs = topicService.topicOptionRemove(u.getUserId(), topicId,
					TopicOption.OPTION_FAVOUR);
			model.addAttribute("option", -1);
		} else {
			rs = topicService.topicOption(u.getUserId(), topicId,
					TopicOption.OPTION_FAVOUR);
			model.addAttribute("option", 1);
		}
		if (rs) {
			model.addAttribute("rs", 1);
		} else {
			model.addAttribute("rs", 0);
		}
		return JSONObject.fromObject(model).toString();
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	@ResponseBody
	public String upload(MultipartHttpServletRequest request) {

		if (!ServletFileUpload.isMultipartContent(request)) {
			throw new IllegalArgumentException(
					"Request is not multipart, please 'multipart/form-data' enctype for your form.");
		}

		Iterator<String> itr = request.getFileNames();
		MultipartFile mpf = null;
		while (itr.hasNext()) {
			mpf = request.getFile(itr.next());
			System.out.println("OriginalFilename:" + mpf.getOriginalFilename());
		}
		return null;
	}

	private String saveImage(MultipartFile image) {
		if (image.isEmpty()) {
			return null;
		}
		String url = PropertyUtils.getValue(PropertyUtils.UPLOADIMAGE_SAVEPATH);
		String rs = null;
		try {
			InputStream stream = image.getInputStream();
			HttpClient client = new DefaultHttpClient();
			HttpPost post = new HttpPost(url);
			MultipartEntity multipartEntity = new MultipartEntity();
			InputStreamBody streamBody = new InputStreamBody(stream, "image");
			multipartEntity.addPart("image", streamBody);
			post.setEntity(multipartEntity);
			HttpResponse response = client.execute(post);
			StringWriter sw = new StringWriter();
			IOUtils.copy(response.getEntity().getContent(), sw, "utf-8");
			rs = sw.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return rs;
	}
}
