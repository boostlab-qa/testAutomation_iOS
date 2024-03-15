<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
   <description>주민번호 뒷자리 입력 키패드 > 1</description>
   <name>btn_keypad_number</name>
   <tag></tag>
   <elementGuidId>1dc2ac26-fece-4d22-9407-810008a01037</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>class</name>
      <type>Main</type>
      <value>android.widget.TextView</value>
      <webElementGuid>c56f0fd9-27ad-449a-964e-61bd73401943</webElementGuid>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>${text}</value>
      <webElementGuid>82499ade-e3d5-45e2-b2e1-8cedeac2abf3</webElementGuid>
   </webElementProperties>
   <locator>//*[@class = 'android.widget.TextView' and (@text = '${text}' or . = '${text}')]</locator>
   <locatorStrategy>XPATH</locatorStrategy>
</MobileElementEntity>
