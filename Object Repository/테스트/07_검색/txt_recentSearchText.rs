<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
   <description>검색 > 최근 검색어 > 리스트(검색어)</description>
   <name>txt_recentSearchText</name>
   <tag></tag>
   <elementGuidId>5b559037-d476-4fcc-8393-2a96ffcf13c2</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>resource-id</name>
      <type>Main</type>
      <value>com.bbros.sayup.debug:id/recentSearchText</value>
      <webElementGuid>5eb482a6-60cf-49f1-a395-0fda93fa1ca1</webElementGuid>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>${text}</value>
      <webElementGuid>90b9fa76-e8c3-4573-b8c4-af06e46f7f9d</webElementGuid>
   </webElementProperties>
   <locator>//*[@resource-id = 'com.bbros.sayup.debug:id/recentSearchText' and (@text = '${text}' or . = '${text}')]</locator>
   <locatorStrategy>XPATH</locatorStrategy>
</MobileElementEntity>
