<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
   <description>도로명 주소</description>
   <name>tv_adress</name>
   <tag></tag>
   <elementGuidId>326be1c8-9e52-43d9-aac3-870819df3461</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>class</name>
      <type>Main</type>
      <value>android.widget.Button</value>
      <webElementGuid>3e0b56c0-b910-40d8-8d45-8c9d8bcc6b34</webElementGuid>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>${text}</value>
      <webElementGuid>dec9e681-c7f0-4062-b9bb-18e4fc640664</webElementGuid>
   </webElementProperties>
   <locator>//*[@class = 'android.widget.Button' and (@text = '${text}' or . = '${text}')]</locator>
   <locatorStrategy>XPATH</locatorStrategy>
</MobileElementEntity>
