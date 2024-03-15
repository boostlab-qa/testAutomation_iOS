<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
   <description>홈 > 컨텐츠 > 동네 인기 병원 (텍스트 더블리스트형)</description>
   <name>txt_tv_title</name>
   <tag></tag>
   <elementGuidId>0b4189ed-2ffb-4c91-9f4e-f883d8fc53d2</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>resource-id</name>
      <type>Main</type>
      <value>com.bbros.sayup.debug:id/tv_title</value>
      <webElementGuid>12799b1a-0795-47b6-b309-0e5ced348e85</webElementGuid>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>${text}</value>
      <webElementGuid>4351a737-4b1e-4b22-bf42-27988bb73d5e</webElementGuid>
   </webElementProperties>
   <locator>//*[@resource-id = 'com.bbros.sayup.debug:id/tv_title' and (@text = '${text}' or . = '${text}')]</locator>
   <locatorStrategy>XPATH</locatorStrategy>
</MobileElementEntity>
