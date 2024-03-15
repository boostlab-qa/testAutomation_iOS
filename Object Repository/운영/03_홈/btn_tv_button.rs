<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
   <description>홈 개인화 > 버튼</description>
   <name>btn_tv_button</name>
   <tag></tag>
   <elementGuidId>e2fb594b-e219-435d-990a-902ff87ab3e7</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>resource-id</name>
      <type>Main</type>
      <value>com.bbros.sayup:id/btn_left</value>
      <webElementGuid>36e01fed-e0f6-4703-a9c2-f90673e70f7f</webElementGuid>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>${text}</value>
      <webElementGuid>b9687b21-6139-4921-a508-e8fa4c087a2a</webElementGuid>
   </webElementProperties>
   <locator>//*[@resource-id = 'com.bbros.sayup:id/btn_left' and (@text = '${text}' or . = '${text}')]</locator>
   <locatorStrategy>XPATH</locatorStrategy>
</MobileElementEntity>
