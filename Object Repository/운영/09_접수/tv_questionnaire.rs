<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
   <description>사전문진표</description>
   <name>tv_questionnaire</name>
   <tag></tag>
   <elementGuidId>8f852aa5-b142-4b53-8c06-58cf12a60ef0</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>resource-id</name>
      <type>Main</type>
      <value>com.bbros.sayup:id/tv_questionnaire</value>
      <webElementGuid>b5d7a248-2b5b-4c46-a055-77c6a2313761</webElementGuid>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>contains</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>${text}</value>
      <webElementGuid>81bc83b7-2aab-4f4d-8f7d-e26407f8adb1</webElementGuid>
   </webElementProperties>
   <locator>//*[@resource-id = 'com.bbros.sayup:id/tv_questionnaire' and (contains(@text, '${text}') or contains(., '${text}'))]</locator>
   <locatorStrategy>ATTRIBUTES</locatorStrategy>
</MobileElementEntity>
