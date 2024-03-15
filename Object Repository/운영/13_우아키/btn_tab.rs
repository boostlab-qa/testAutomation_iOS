<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
   <description>우아키 > 탭</description>
   <name>btn_tab</name>
   <tag></tag>
   <elementGuidId>0c05d392-5664-4016-971a-344ae3e112ba</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>class</name>
      <type>Main</type>
      <value>android.widget.TextView</value>
      <webElementGuid>a779547d-5352-4a9c-a9e1-ea0cdc53714a</webElementGuid>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>${text}</value>
      <webElementGuid>a3df4a71-2817-4d8f-a9c8-1d59b68fa016</webElementGuid>
   </webElementProperties>
   <locator>//*[@class = 'android.widget.TextView' and (@text = '${text}' or . = '${text}')]</locator>
   <locatorStrategy>XPATH</locatorStrategy>
</MobileElementEntity>
