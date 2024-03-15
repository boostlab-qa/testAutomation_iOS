<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
   <description>진료 대상 선택 > 이름</description>
   <name>txt_name</name>
   <tag></tag>
   <elementGuidId>75caf4bf-bddb-4031-925e-7e4feefe5dd3</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>resource-id</name>
      <type>Main</type>
      <value>com.bbros.sayup:id/nameTxt</value>
      <webElementGuid>5cf160bc-94d4-4f11-accc-888b72f3e23c</webElementGuid>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>${text}</value>
      <webElementGuid>2d5d1370-fbb2-4125-98d0-bd1e800fde56</webElementGuid>
   </webElementProperties>
   <locator>//*[@resource-id = 'com.bbros.sayup:id/nameTxt' and (@text = '${text}' or . = '${text}')]</locator>
   <locatorStrategy>XPATH</locatorStrategy>
</MobileElementEntity>
