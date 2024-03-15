<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
   <description>주소 설정 > 주소 이름</description>
   <name>txt_tv_title</name>
   <tag></tag>
   <elementGuidId>f88280c5-9065-40e6-9537-d06ef6b604ae</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>resource-id</name>
      <type>Main</type>
      <value>com.bbros.sayup.debug:id/tv_title</value>
      <webElementGuid>be4fabcd-e7e6-49a4-8302-e13719658040</webElementGuid>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>${text}</value>
      <webElementGuid>25a048f9-d49e-49cc-bc4a-1756ad6aa498</webElementGuid>
   </webElementProperties>
   <locator>//*[@resource-id = 'com.bbros.sayup.debug:id/tv_title' and (@text = '${text}' or . = '${text}')]</locator>
   <locatorStrategy>XPATH</locatorStrategy>
</MobileElementEntity>
