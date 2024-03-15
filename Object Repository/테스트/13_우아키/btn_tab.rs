<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
   <description>우아키 > 탭</description>
   <name>btn_tab</name>
   <tag></tag>
   <elementGuidId>2eb82415-fce2-447e-99c0-605d35a11135</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>class</name>
      <type>Main</type>
      <value>android.widget.TextView</value>
      <webElementGuid>8bec3102-9ed1-417f-b839-4258f2b732dc</webElementGuid>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>${text}</value>
      <webElementGuid>5f78d392-38cb-46a5-98b4-0f7ed18ed620</webElementGuid>
   </webElementProperties>
   <locator>//*[@class = 'android.widget.TextView' and (@text = '${text}' or . = '${text}')]</locator>
   <locatorStrategy>XPATH</locatorStrategy>
</MobileElementEntity>
