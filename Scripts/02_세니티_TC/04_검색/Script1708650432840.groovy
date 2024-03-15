import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import io.appium.java_client.android.nativekey.AndroidKey
import io.appium.java_client.android.nativekey.KeyEvent
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.AppiumDriver
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import io.appium.java_client.MobileElement

//STEP01 - 병원명으로 검색하여 병원 목록 선택
'STEP - 똑닥 앱 실행'
Mobile.startExistingApplication(GlobalVariable.appid)

'STEP - 홈 검색 영역 선택'
Mobile.tap(findTestObject('테스트/03_홈/area_view_search_bar'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 검색 화면에서 입력 영역 선택'
Mobile.tap(findTestObject('테스트/07_검색/input_search'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 병원명 입력'
Mobile.setText(findTestObject('테스트/07_검색/input_search'), GlobalVariable.hospital_name, GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 돋보기 버튼 선택'
Mobile.tap(findTestObject('테스트/07_검색/btn_search'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 검색 결과 첫번째 리스트 [+] 버튼 선택'
Mobile.tap(findTestObject('테스트/07_검색/btn_result_plus'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 검색 결과 목록에 검색한 병원명이 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/07_검색/txt_titleTxt', [('text') : GlobalVariable.hospital_name]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) 

'기대결과 - 검색 화면에 필터 버튼이 "관련순"으로 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/07_검색/btn_tvSortType', [('text') : '관련순']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 검색화면 하단에 [진료중] 버튼이 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/07_검색/btn_filter_open'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 검색화면 하단에 [지도보기] 버튼이 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/07_검색/btn_map'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 검색 결과 영역 병원 목록 선택'
Mobile.tap(findTestObject('테스트/07_검색/txt_hospital_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 병원상세 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('테스트/08_병원상세/txt_tv_title', [('text') : GlobalVariable.hospital_name]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 병원상세 화면에서 [<-] 뒤로가기 버튼 선택'
Mobile.tap(findTestObject('테스트/08_병원상세/btn_iv_back'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 검색 화면에서 검색 입력 영역 우측 [x] 버튼 선택'
Mobile.tap(findTestObject('테스트/07_검색/btn_search_clear'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
//

//STEP02 - 질병명으로 검색하여 Sort 필터 변경 및 병원 목록 선택
'STEP - 검색 영역 선택'
Mobile.tap(findTestObject('테스트/07_검색/input_search'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 질병 검색어 입력'
Mobile.setText(findTestObject('테스트/07_검색/input_search'), '감기', GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [검색] 버튼 선택'
Mobile.tap(findTestObject('테스트/07_검색/btn_search'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 검색 결과 첫번째 리스트 [+] 버튼 선택'
Mobile.tap(findTestObject('테스트/07_검색/btn_result_plus'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 질벙졍보 설명 영역이 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/07_검색/txt_disease_description', [('text') : '어려운 질병정보 상세보기']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 질병정보 설명 영역에 [보기] 버튼이 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/07_검색/btn_see'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 검색 결과 목록이 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/07_검색/txt_hospital_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 검색 화면에 필터 버튼이 "관련순"으로 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/07_검색/btn_tvSortType', [('text') : '관련순']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - sort 필터 선택'
Mobile.tap(findTestObject('테스트/07_검색/btn_tvSortType', [('text') : '관련순']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
'기대결과 - 바텀시트가 노출되다.'
Mobile.verifyElementVisible(findTestObject('테스트/07_검색/txt_sort_filter_title'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
'STEP - 거리순 필터 선택'
Mobile.tap(findTestObject('테스트/07_검색/txt_sort_filter_distance'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
'STEP - [필터 적용] 버튼 선택'
Mobile.tap(findTestObject('테스트/00_공통/btn_confirmBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 필터가 "거리순"으로 변경된다.'
Mobile.verifyElementVisible(findTestObject('테스트/07_검색/btn_tvSortType', [('text') : '거리순']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 병원명 저장'
hospitalName_1 = Mobile.getText(findTestObject('테스트/07_검색/txt_hospital_name'), GlobalVariable.waitTime)

'STEP - 병원 목록 선택'
Mobile.tap(findTestObject('테스트/07_검색/txt_hospital_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 병원상세 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('테스트/08_병원상세/txt_tv_title', [('text') : hospitalName_1]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 병원상세 화면에서 [<-] 뒤로가기 버튼 선택'
Mobile.tap(findTestObject('테스트/08_병원상세/btn_iv_back'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 검색 화면에서 검색 입력 영역 우측 [x] 버튼 선택'
Mobile.tap(findTestObject('테스트/07_검색/btn_search_clear'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
//

//STEP03 - 진료과목으로 검색하여 진료과목 필터 변경 및 병원 목록 선택
'STEP - 검색 영역 선택'
Mobile.tap(findTestObject('테스트/07_검색/input_search'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 진료과 검색어 입력'
Mobile.setText(findTestObject('테스트/07_검색/input_search'), '소아청소년과', GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
'STEP - [검색] 버튼 선택'
Mobile.tap(findTestObject('테스트/07_검색/btn_search'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
'STEP - 검색 결과 첫번째 리스트 [+] 버튼 선택'
Mobile.tap(findTestObject('테스트/07_검색/btn_result_plus'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 검색 결과 목록이 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/07_검색/txt_hospital_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 검색 화면에 필터 버튼이 "관련순"으로 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/07_검색/btn_tvSortType', [('text') : '관련순']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 결과 목록 대표 진료과목 영역에 검색한 진료과목이 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/07_검색/txt_categoryTxt', [('text') : '소아청소년과']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [진료과목] 필터 선택'
Mobile.tap(findTestObject('테스트/00_공통/btn_commonBtnTitle', [('text') : '진료과목']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 진료과목 바텀 시트에서 "이비인후과" 진료과목 선택'
Mobile.tap(findTestObject('테스트/07_검색/txt_category_text', [('text') : '이비인후과']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 진료과목 필터가 [이비인후과]로 변경된다.'
Mobile.verifyElementVisible(findTestObject('테스트/00_공통/btn_commonBtnTitle', [('text') : '이비인후과']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 병원 목록이 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/07_검색/txt_hospital_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 병원 목록 대표 진료과목이 "이비인후과"로 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/07_검색/txt_categoryTxt', [('text') : '이비인후과']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
'STEP - 병원명 저장'
hospitalName_2 = Mobile.getText(findTestObject('테스트/07_검색/txt_hospital_name'), GlobalVariable.waitTime)

'STEP - 병원 목록 선택'
Mobile.tap(findTestObject('테스트/07_검색/txt_hospital_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 병원상세 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('테스트/08_병원상세/txt_tv_title', [('text') : hospitalName_2]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 병원상세 화면에서 [<-] 뒤로가기 버튼 선택'
Mobile.tap(findTestObject('테스트/08_병원상세/btn_iv_back'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 검색 화면에서 검색 입력 영역 우측 [x] 버튼 선택'
Mobile.tap(findTestObject('테스트/07_검색/btn_search_clear'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

//STEP04 - 검색화면에서 주소 변경
'STEP - 검색 영역 선택'
Mobile.tap(findTestObject('테스트/07_검색/input_search'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 진료과 검색어 입력'
Mobile.setText(findTestObject('테스트/07_검색/input_search'), '소아청소년과', GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
'STEP - [검색] 버튼 선택'
Mobile.tap(findTestObject('테스트/07_검색/btn_search'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
'STEP - 검색 결과 첫번째 리스트 [+] 버튼 선택'
Mobile.tap(findTestObject('테스트/07_검색/btn_result_plus'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 주소영역 선택'
Mobile.tap(findTestObject('테스트/07_검색/btn_searchRegionBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 주소 설정 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('테스트/00_공통/txt_page_titleTxt', [('text') : '주소 설정']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [현위치에서 병원 찾기] 버튼 선택'
Mobile.tap(findTestObject('테스트/06_주소설정/btn_current_location'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 검색 화면 주소 이름 현위치가 노출된다.'
if(GlobalVariable.adress_name == '상동')
{
	Mobile.verifyElementVisible(findTestObject('테스트/07_검색/txt_search_adress_name', [('text') : '상동']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}
else if(GlobalVariable.adress_name == '여의도동')
{
	Mobile.verifyElementVisible(findTestObject('테스트/07_검색/txt_search_adress_name', [('text') : '여의도동']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'기대결과 - 병원 목록이 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/07_검색/txt_hospital_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 주소영역 선택'
Mobile.tap(findTestObject('테스트/07_검색/btn_searchRegionBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [우리집] 선택'
Mobile.tap(findTestObject('테스트/06_주소설정/btn_my_home'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 검색 화면 주소 이름에 우리집이 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/07_검색/txt_search_adress_name', [('text') : '우리집']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 병원 목록이 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/07_검색/txt_hospital_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

//STEP05 - 검색 화면에서 최근/추천 검색어 확인하고 최근 검색어 삭제
'STEP - 검색 화면에서 검색 입력 영역 우측 [x] 버튼 선택'
Mobile.tap(findTestObject('테스트/07_검색/btn_search_clear'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 추천 검색어 목록이 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/07_검색/txt_recommendKeywordTitle'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 최근 검색어 영역에 검색어 목록이 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/07_검색/txt_recentSearchText', [('text') : GlobalVariable.hospital_name]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 최근 검색어 [전체삭제] 버튼 선택'
Mobile.tap(findTestObject('테스트/07_검색/btn_all_delete'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 삭제한 최근 검색어가 노출되지 않는다.'
Mobile.verifyElementNotVisible(findTestObject('테스트/07_검색/txt_recentSearchText', [('text') : GlobalVariable.hospital_name]), GlobalVariable.waitTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 앱 종료'
try {
	AppiumDriver<?> driver = MobileDriverFactory.getDriver()
	driver.terminateApp(GlobalVariable.appid)

} catch (Exception e) {
}