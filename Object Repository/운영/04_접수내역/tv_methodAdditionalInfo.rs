<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
   <description>간편결제 수단</description>
   <name>tv_methodAdditionalInfo</name>
   <tag></tag>
   <elementGuidId>1f231c40-9988-4f75-9d36-4179cb12c6d5</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>resource-id</name>
      <type>Main</type>
      <value>com.bbros.sayup:id/methodAdditionalInfo</value>
      <webElementGuid>261116ce-c634-42ea-8d04-1cf1da78a210</webElementGuid>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>contains</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>${text}</value>
      <webElementGuid>5e7eb5e4-7e0a-418b-82f0-6fd354fc7848</webElementGuid>
   </webElementProperties>
   <locator>//*[@resource-id = 'com.bbros.sayup:id/methodAdditionalInfo' and (contains(@text, '${text}') or contains(., '${text}'))]</locator>
   <locatorStrategy>ATTRIBUTES</locatorStrategy>
</MobileElementEntity>
