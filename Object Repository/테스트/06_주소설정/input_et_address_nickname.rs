<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
   <description>주소설정 > 주소검색 > 상세주소 입력 > 주소 이름</description>
   <name>input_et_address_nickname</name>
   <tag></tag>
   <elementGuidId>42e2d6fe-9559-4305-a3e9-f03cd02e9661</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>resource-id</name>
      <type>Main</type>
      <value>com.bbros.sayup.debug:id/et_input_field</value>
      <webElementGuid>57de554e-3be4-4657-8316-0e940512a6b5</webElementGuid>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>${text}</value>
      <webElementGuid>2c03290a-c671-4e49-902b-9b70ca955b64</webElementGuid>
   </webElementProperties>
   <locator>//*[@resource-id = 'com.bbros.sayup.debug:id/et_input_field' and (@text = '${text}' or . = '${text}')]</locator>
   <locatorStrategy>XPATH</locatorStrategy>
</MobileElementEntity>
