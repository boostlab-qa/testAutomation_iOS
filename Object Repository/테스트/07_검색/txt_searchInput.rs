<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
   <description>검색 > 검색어</description>
   <name>txt_searchInput</name>
   <tag></tag>
   <elementGuidId>04c6c0e6-acc1-4019-80ba-ccdd4d116c3b</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>resource-id</name>
      <type>Main</type>
      <value>com.bbros.sayup.debug:id/searchInput</value>
      <webElementGuid>0e5a1848-2a67-4704-97c2-aa2d836338fb</webElementGuid>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>${text}</value>
      <webElementGuid>0d068a5f-4a10-47a2-8980-388f6ffc8bbe</webElementGuid>
   </webElementProperties>
   <locator>//*[@resource-id = 'com.bbros.sayup.debug:id/searchInput' and (@text = '${text}' or . = '${text}')]</locator>
   <locatorStrategy>XPATH</locatorStrategy>
</MobileElementEntity>
