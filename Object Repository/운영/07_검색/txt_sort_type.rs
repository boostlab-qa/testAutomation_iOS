<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
   <description>검색 > 검색결과 > sort 필터</description>
   <name>txt_sort_type</name>
   <tag></tag>
   <elementGuidId>dac3248f-5c6f-4d6b-a3a7-b5f16f26fc1a</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>resource-id</name>
      <type>Main</type>
      <value>com.bbros.sayup:id/tvSortType</value>
      <webElementGuid>b74f7892-9b06-4fad-8a10-0e87ef4ff797</webElementGuid>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>${text}</value>
      <webElementGuid>ac014022-70cd-48d6-ab64-b2a6ee02115b</webElementGuid>
   </webElementProperties>
   <locator>//*[@resource-id = 'com.bbros.sayup:id/tvSortType' and (@text = '${text}' or . = '${text}')]</locator>
   <locatorStrategy>XPATH</locatorStrategy>
</MobileElementEntity>
