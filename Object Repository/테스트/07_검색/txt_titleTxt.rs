<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
   <description>검색 결과 > 병원명</description>
   <name>txt_titleTxt</name>
   <tag></tag>
   <elementGuidId>7b955bbc-47b5-43d6-ad7d-51f2475b0d1e</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>resource-id</name>
      <type>Main</type>
      <value>com.bbros.sayup.debug:id/titleTxt</value>
      <webElementGuid>3aa889bc-825c-49d1-8867-03edd394b58d</webElementGuid>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>${text}</value>
      <webElementGuid>7ff2d811-1164-4050-a607-adff751882b9</webElementGuid>
   </webElementProperties>
   <locator>//*[@resource-id = 'com.bbros.sayup.debug:id/titleTxt' and (@text = '${text}' or . = '${text}')]</locator>
   <locatorStrategy>XPATH</locatorStrategy>
</MobileElementEntity>
