<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
   <description>화면 타이틀</description>
   <name>txt_page_titleTxt</name>
   <tag></tag>
   <elementGuidId>34e9c03a-7067-4dab-8b40-ea4ba970a840</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>resource-id</name>
      <type>Main</type>
      <value>com.bbros.sayup:id/titleTxt</value>
      <webElementGuid>1c7f3241-6e0b-4bf6-bee5-89ffc6159bc3</webElementGuid>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>${text}</value>
      <webElementGuid>9c9c8ef5-bb52-44de-9e71-cf49747328e1</webElementGuid>
   </webElementProperties>
   <locator>//*[@resource-id = 'com.bbros.sayup:id/titleTxt' and (@text = '${text}' or . = '${text}')]</locator>
   <locatorStrategy>XPATH</locatorStrategy>
</MobileElementEntity>
