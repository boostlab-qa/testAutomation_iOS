<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
   <description>홈 > 주소 이름 영역</description>
   <name>txt_home_adress_name</name>
   <tag></tag>
   <elementGuidId>2b005e83-6426-4f9d-a64a-efabc52f2b01</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>resource-id</name>
      <type>Main</type>
      <value>com.bbros.sayup:id/tv_title</value>
      <webElementGuid>07760db3-1b02-4e7d-b256-13cf036aa1bd</webElementGuid>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>${text}</value>
      <webElementGuid>0f9b60c0-86fd-4c7f-ad19-df84804793a7</webElementGuid>
   </webElementProperties>
   <locator>//*[@resource-id = 'com.bbros.sayup:id/tv_title' and (@text = '${text}' or . = '${text}')]</locator>
   <locatorStrategy>XPATH</locatorStrategy>
</MobileElementEntity>
