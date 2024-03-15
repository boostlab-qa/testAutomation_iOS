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

//STEP01 - 가족관리 화면에서 자녀 등록
'STEP - 똑닥 앱 실행'
Mobile.startExistingApplication(GlobalVariable.appid)

'STEP - 홈 [가족관리] 메뉴 선택'
Mobile.tap(findTestObject('테스트/03_홈/btn_family'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 가족관리 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('테스트/00_공통/txt_page_titleTxt', [('text') : '가족관리']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [자녀추가] 버튼 선택'
Mobile.tap(findTestObject('테스트/10_가족관리/btn_child_add'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 자녀추가 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('테스트/00_공통/txt_page_titleTxt', [('text') : '자녀추가']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 이름 입력'
Mobile.setText(findTestObject('테스트/10_가족관리/input_add_family_name'), GlobalVariable.male, GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 키보드 닫기'
Mobile.pressBack()

'STEP - 주민번호 앞자리 입력'
Mobile.setText(findTestObject('테스트/10_가족관리/input_add_ssn_front_number'), GlobalVariable.male_birth_date, GlobalVariable.fixedTime)

'STEP - 주민번호 뒷자리 영역 선택'
Mobile.tap(findTestObject('테스트/10_가족관리/tv_et_ssn_back_number'), GlobalVariable.fixedTime, FailureHandling.STOP_ON_FAILURE)

'STEP - 주민번호 뒷자리 "3333333" 입력'
for(i = 1; i <= 7; i++)
{
	Mobile.tap(findTestObject('테스트/10_가족관리/btn_keypad_number', [('text') : '3']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'STEP - 화면 스크롤 이동'
Mobile.scrollToText('고유식별정보의 수집 및 이용 동의')

'STEP - 이용약관 가족 대리 접수 동의 체크 선택'
Mobile.tap(findTestObject('테스트/10_가족관리/btn_add_use', [('text') : '자녀 대리 접수 동의']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 이용약관 똑닥 QR 진료카드 체크 선택'
Mobile.tap(findTestObject('테스트/10_가족관리/btn_add_use', [('text') : '고유식별정보의 수집 및 이용 동의']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [완료] 버튼 선택'
Mobile.tap(findTestObject('테스트/10_가족관리/btn_add_complet'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 가족관리 화면에 등록한 자녀정보가 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/10_가족관리/txt_name', [('text') : GlobalVariable.male]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
Mobile.verifyElementVisible(findTestObject('테스트/10_가족관리/txt_birthday', [('text') : GlobalVariable.male_info]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 자녀 선택'
Mobile.tap(findTestObject('테스트/10_가족관리/txt_name', [('text') : GlobalVariable.male]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [정보보기] 버튼 노출되면 선택'
if(Mobile.waitForElementPresent(findTestObject('테스트/10_가족관리/btn_info'), GlobalVariable.waitTime, FailureHandling.CONTINUE_ON_FAILURE))
{
	'STEP - [정보보기] 버튼 선택'
	Mobile.tap(findTestObject('테스트/10_가족관리/btn_info'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'기대결과 - 자녀정보 바텀시트가 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/10_가족관리/txt_name', [('text') : GlobalVariable.male]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
Mobile.verifyElementText(findTestObject('테스트/10_가족관리/txt_child_ssn'), '230301-3333333', FailureHandling.CONTINUE_ON_FAILURE)
//

//STEP02 - 가족관리 화면에서 자녀 편집
'STEP - [편집] 버튼 선택'
Mobile.tap(findTestObject('테스트/10_가족관리/btn_edit'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 가족 관리 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('테스트/10_가족관리/tv_toolbar_title', [('text') : '가족 관리']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 주민번호 뒷자리 선택'
Mobile.tap(findTestObject('테스트/10_가족관리/tv_back_number'), GlobalVariable.fixedTime, FailureHandling.STOP_ON_FAILURE)

'STEP - 주민번호 뒷자리 "4444444" 수정'
for(i = 1; i <= 7; i++)
{
	Mobile.tap(findTestObject('테스트/10_가족관리/btn_keypad_number', [('text') : '4']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'STEP - 주소 입력 영역 선택'
Mobile.tap(findTestObject('테스트/10_가족관리/input_adress', [('text') : '주소 입력하기']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 주소 검색하기 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('테스트/06_주소설정/txt_tv_title', [('text') : '주소 검색하기']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 주소 입력'
Mobile.setText(findTestObject('테스트/06_주소설정/input_EditText'), '경기 시흥시 배곧전원로 12-1', GlobalVariable.fixedTime)

'STEP - [검색] 버튼 선택'
Mobile.tap(findTestObject('테스트/06_주소설정/btn_adress_search'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 도로명 주소 선택'
Mobile.tap(findTestObject('테스트/06_주소설정/tv_adress', [('text') : '경기 시흥시 배곧전원로 12-1']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 상세주소 입력 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('테스트/06_주소설정/tv_toolbar_title', [('text') : '상세주소 입력']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 상세주소 입력'
Mobile.setText(findTestObject('테스트/06_주소설정/et_input_field', [('text') : '상세주소를 입력해주세요']), '1234', GlobalVariable.fixedTime)

'STEP - [등록] 버튼 선택'
Mobile.tap(findTestObject('테스트/06_주소설정/btn_dds_submit_button', [('text') : '등록']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 자녀 상세 팝업에 편집한 주소가 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/10_가족관리/input_adress', [('text') : '경기 시흥시 배곧전원로 12-1 (배곧동) 1234 (15010)']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [완료] 버튼 선택'
Mobile.tap(findTestObject('테스트/10_가족관리/btn_submit', [('text') : '완료']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [정보보기] 버튼 노출되면 선택'
if(Mobile.waitForElementPresent(findTestObject('테스트/10_가족관리/btn_info'), GlobalVariable.waitTime, FailureHandling.CONTINUE_ON_FAILURE))
{
	'STEP - [정보보기] 버튼 선택'
	Mobile.tap(findTestObject('테스트/10_가족관리/btn_info'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'기대결과 - 바텀시트에 편집한 자녀정보가 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/10_가족관리/txt_name', [('text') : GlobalVariable.male]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
Mobile.verifyElementText(findTestObject('테스트/10_가족관리/txt_child_ssn'), '230301-4444444', FailureHandling.CONTINUE_ON_FAILURE)
Mobile.verifyElementText(findTestObject('테스트/10_가족관리/txt_adress'), '경기 시흥시 배곧전원로 12-1 ', FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [x] 버튼 선택'
Mobile.tap(findTestObject('테스트/10_가족관리/btn_close'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 가족관리 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('테스트/00_공통/txt_page_titleTxt', [('text') : '가족관리']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
//

//STEP03 - 가족관리 화면에서 자녀 삭제
'STEP - 자녀 선택'
Mobile.tap(findTestObject('테스트/10_가족관리/txt_name_list', [('text') : GlobalVariable.male]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [정보보기] 버튼 노출되면 선택'
if(Mobile.waitForElementPresent(findTestObject('테스트/10_가족관리/btn_info'), GlobalVariable.waitTime, FailureHandling.CONTINUE_ON_FAILURE))
{
	'STEP - [정보보기] 버튼 선택'
	Mobile.tap(findTestObject('테스트/10_가족관리/btn_info'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'STEP - [편집] 버튼으로 스크롤 이동'
Mobile.scrollToText('편집')

'STEP - [편집] 버튼 선택'
Mobile.tap(findTestObject('테스트/10_가족관리/btn_edit'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [삭제] 버튼 선택'
Mobile.tap(findTestObject('테스트/10_가족관리/btn_delete'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [확인] 버튼 선택'
Mobile.tap(findTestObject('테스트/10_가족관리/btn_submit_button'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [<-] 이전 버튼 선택'
Mobile.tap(findTestObject('테스트/00_공통/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 가족관리 화면에 삭제한 자녀 정보가 노출되지 않는다.'
Mobile.verifyElementNotVisible(findTestObject('테스트/10_가족관리/txt_name_list', [('text') : GlobalVariable.male]), GlobalVariable.waitTime, FailureHandling.CONTINUE_ON_FAILURE)
//

'STEP - 앱 종료'
try {
	AppiumDriver<?> driver = MobileDriverFactory.getDriver()
	driver.terminateApp(GlobalVariable.appid)

} catch (Exception e) {
}




