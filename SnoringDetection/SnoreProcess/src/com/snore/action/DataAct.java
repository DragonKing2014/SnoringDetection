package com.snore.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.snore.service.UserService;
import com.snore.util.Data;
import com.snore.util.PageData;

@Controller
public class DataAct {

	private UserService userService = new UserService();

	@RequestMapping(value = "/query", method = RequestMethod.POST)
	public String queryByDate(HttpServletRequest request, ModelMap model) {
		return "/data/snorequery";
	}

	@RequestMapping(value = "/data", method = RequestMethod.POST)
	public String data(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, String date)
			throws ServletException, IOException {
		System.out.println("用户输入日期：" + date);

		List<Data> datas = userService.queryData(date);
		String welcome = "";

		//验证用户当天是否使用过检测
		if (datas.size() == 0) {
			welcome = "您在 " + date + " 这一天没有使用过鼾声监测";
			// 转发请求
			request.setAttribute("welcome", welcome);
			request.getRequestDispatcher("nodata.jsp").forward(request,
					response);
		} else {
			welcome = "以下是您在 " + date + "这一天的鼾声数据记录";
			model.addAttribute("welcome", welcome);
		}

		//存放前端展示的数据
		List<PageData> pageDatas=new ArrayList<>();
		
		
		if (datas.size()!=0) {
			//存放第一个id
			int count=1;
			datas.get(0).setCount(1);
			
			//给data打标签
			for(int i=1;i<datas.size();i++){
				if (datas.get(i-1).getDateTime().equals(datas.get(i).getDateTime())) {
					datas.get(i).setCount(count);
					continue;
				}
				count++;
			}
			
			//根据count循环遍历,准备展示的数据集合
			for(int i=1;i<=count;i++){
				PageData pageData=new PageData();
				double sleepTime=0;
				double snoreTime=0;
				double snoreBigTime=0;
				
				double snoreMax=0;
				String snoreMaxMoment="";
				String startDetectTime="";
				
				SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
				
				for (int j = 0; j < datas.size(); j++) {
					if (datas.get(j).getCount()==i) {
						//统计打鼾总时长
						snoreTime=snoreTime+datas.get(j).getDuration();
						//统计睡眠总时长
						sleepTime=datas.get(j).getEndTime().getTime()
								-datas.get(j).getDateTime().getTime();
						//统计较大打鼾声时间
						if (datas.get(j).getMaximumValue()>0.88) {
							snoreBigTime=snoreBigTime+(int)datas.get(j).getDuration();
						}
						//统计最大打鼾时刻
						if (datas.get(j).getMeanValue()>snoreMax) {
							snoreMax=datas.get(j).getMeanValue();
							snoreMaxMoment=sdf.format(datas.get(j).getStartTime());
							
						}
						startDetectTime=sdf.format(datas.get(j).getDateTime());
						
					}
				}
				
				pageData.setId(i);
				pageData.setSleepTime((int)sleepTime/1000);
				pageData.setSnoreNormalTime((int)snoreTime);
				pageData.setSnoreBigTime((int)snoreBigTime);
				pageData.setSnoreNormalTime((int)(snoreTime-snoreBigTime));
				pageData.setSnoreMaxMoment(snoreMaxMoment);
				pageData.setSnoreTime((int)snoreTime);
				pageData.setStartDetectTime(startDetectTime);
				
				pageDatas.add(pageData);
			}
			model.addAttribute("count",count);
		}
		
		
		model.addAttribute("datas", datas);
		model.addAttribute("pageDatas",pageDatas);

		return "/data/snoredata";
	}

}
