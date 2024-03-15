<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
   <description>검색 > 질병 검색 > 질병 정보 > 안내문구</description>
   <name>txt_disease_description</name>
   <tag></tag>
   <elementGuidId>0dda4d6d-a8f8-4ef3-a397-ed4d783f46da</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>resource-id</name>
      <type>Main</type>
      <value>com.bbros.sayup.debug:id/diseaseDescription</value>
      <webElementGuid>24f84c99-4795-421b-9b6e-d26ed3426f8d</webElementGuid>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>${text}</value>
      <webElementGuid>96252c27-300a-423b-a6bb-6bdcd0e1ce30</webElementGuid>
   </webElementProperties>
   <locator>//*[@resource-id = 'com.bbros.sayup.debug:id/diseaseDescription' and (@text = '${text}' or . = '${text}')]</locator>
   <locatorStrategy>XPATH</locatorStrategy>
</MobileElementEntity>
