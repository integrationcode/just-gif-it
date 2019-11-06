package com.justgifit;

import java.io.File;

import javax.inject.Inject;

import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.FormContentFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.justgifit.services.ConverterService;
import com.justgifit.services.GifEncoderService;
import com.justgifit.services.VideoDecoderService;
import com.madgag.gif.fmsware.AnimatedGifEncoder;

@Configuration
@ConditionalOnClass({FFmpegFrameGrabber.class,AnimatedGifEncoder.class})
@EnableConfigurationProperties(JustGifItProperties.class)
public class JustGifItAutoConfiguration {
	
//	@Value("${spring.servlet.multipart.location}/gif/")
//	private String gifLocation;
	
//	@PostConstruct
//	private void init() {
//		File gifFolder = new File(gifLocation);
//		if(!gifFolder.exists())
//			gifFolder.mkdir();
//	}
	
	@Inject
	private JustGifItProperties properties;
	
	@ConditionalOnProperty(prefix = "com.justgifit", name = "create-result-dir")
	private Boolean createResultDir() {
//		File gifFolder = new File(gifLocation);
//		if(!gifFolder.exists())
//			gifFolder.mkdir();
		
		if(!properties.getGifLocation().exists())
			properties.getGifLocation().mkdir();
		
		return true;
	}
	
	@Bean
	@ConditionalOnMissingBean(VideoDecoderService.class)
	public VideoDecoderService videoDecoderService() {
		return new VideoDecoderService();
	}

	@Bean
	@ConditionalOnMissingBean(GifEncoderService.class)
	public GifEncoderService gifEncoderService() {
		return new GifEncoderService();
	}

	@Bean
	@ConditionalOnMissingBean(ConverterService.class)
	public ConverterService converterService() {
		return new ConverterService();
	}

	@Configuration
	@ConditionalOnWebApplication
	public static class WebConfiguration{
		
		@Value("${spring.servlet.multipart.location}/gif/")
		private String gifLocation;
		
		@Bean
		@ConditionalOnProperty(prefix = "com.justgifit", name = "optimize")
		public FilterRegistrationBean<HiddenHttpMethodFilter> deregisterHiddenHttpFilterMethods(HiddenHttpMethodFilter filter) {
			FilterRegistrationBean<HiddenHttpMethodFilter> bean = new FilterRegistrationBean<HiddenHttpMethodFilter>();
			bean.setFilter(filter);
			bean.setEnabled(false);
			return bean;
		}
		
		@Bean
		@ConditionalOnProperty(prefix = "com.justgifit", name = "optimize")
		public FilterRegistrationBean<FormContentFilter> deregisterHttpPutForm(FormContentFilter filter) {
			FilterRegistrationBean<FormContentFilter> bean = new FilterRegistrationBean<>();
			bean.setFilter(filter);
			bean.setEnabled(false);
			return bean;
		}
		
		@Bean
		public WebMvcConfigurer webMvcConfigurer() {
			return new WebMvcConfigurer() {
				@Override
				public void addResourceHandlers(ResourceHandlerRegistry registry) {
					System.out.println("****************************************"+gifLocation);
					registry.addResourceHandler("/gif/**").addResourceLocations("file: " + gifLocation);
					WebMvcConfigurer.super.addResourceHandlers(registry);
				}
			};
		}
		
		
	}
}
