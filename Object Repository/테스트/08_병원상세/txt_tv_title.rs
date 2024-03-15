<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
   <description>병원상세 > 페이지 타이틀</description>
   <name>txt_tv_title</name>
   <tag></tag>
   <elementGuidId>d38d6c51-bf9d-4d02-a521-0393d053a833</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>resource-id</name>
      <type>Main</type>
      <value>com.bbros.sayup.debug:id/tv_title</value>
      <webElementGuid>9e2fbc43-2548-4991-b75f-eafea5d84127</webElementGuid>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>${text}</value>
      <webElementGuid>57a59b32-4896-4ccc-b2a0-3eacb1bcabe7</webElementGuid>
   </webElementProperties>
   <locator>//*[@resource-id = 'com.bbros.sayup.debug:id/tv_title' and (@text = '${text}' or . = '${text}')]</locator>
   <locatorStrategy>XPATH</locatorStrategy>
</MobileElementEntity>
