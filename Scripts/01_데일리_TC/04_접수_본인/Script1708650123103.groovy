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

// 실행할 CMD 명령어
def command = "adb shell screenrecord --time-limit 122 --output-format mp4 --size 1080x2640 --bit-rate 5000000 /sdcard/04_접수_본인.mp4"

// 명령어 실행
def processBuilder = new ProcessBuilder(command.split())
def process = processBuilder.start()

'STEP - 똑닥 앱 실행'
Mobile.startExistingApplication(GlobalVariable.appid)

'STEP- [마이페이지] 메뉴 선택'
Mobile.tap(findTestObject('운영/03_홈/btn_menu_mypage'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP- 로그아웃 상태인 경우 로그인'
if (Mobile.waitForElementPresent(findTestObject('운영/05_마이페이지/btn_login'), GlobalVariable.waitTime))
{
		'STEP- [로그인] 버튼 선택'
		Mobile.tap(findTestObject('운영/05_마이페이지/btn_login'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
		
		'STEP - [이메일 로그인] 버튼 선택'
		Mobile.tap(findTestObject('운영/01_온보딩/btn_tvEmailLoginBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
		
		'STEP - 이메일 id 입력'
		Mobile.setText(findTestObject('운영/02_로그인/input_etEmail'), GlobalVariable.email_id, GlobalVariable.fixedTime)
		
		'STEP - 이메일 password 입력'
		Mobile.setText(findTestObject('운영/02_로그인/input_etPassword'), GlobalVariable.email_password, GlobalVariable.fixedTime)
		
		'STEP - [로그인하기] 버튼 선택'
		Mobile.tap(findTestObject('운영/02_로그인/btn_tvLoginConfirm'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
		
		'카카오 전환 유도 팝업 노출 시 [오늘 하루 보지 않기] 버튼 선택'
		if (Mobile.waitForElementPresent(findTestObject('운영/03_홈/01_home_popup/btn_kakao_agree_skip'), GlobalVariable.waitTime))
		{
				Mobile.tap(findTestObject('운영/03_홈/01_home_popup/btn_kakao_agree_skip'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
		}
}

'STEP- [홈] 메뉴 선택'
Mobile.tap(findTestObject('운영/03_홈/btn_menu_home'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 홈 검색 영역 선택'
Mobile.tap(findTestObject('운영/03_홈/area_view_search_bar'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 병원 검색어 입력'
Mobile.setText(findTestObject('운영/07_검색/input_search'), GlobalVariable.hospital_name, GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [검색] 버튼 선택'
Mobile.tap(findTestObject('운영/07_검색/btn_search'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 검색 결과 첫번째 리스트 [+] 버튼 선택'
Mobile.tap(findTestObject('운영/07_검색/btn_result_plus'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 검색 결과 병원 선택'
Mobile.tap(findTestObject('운영/07_검색/txt_hospital_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [바로접수] 버튼 선택'
Mobile.tap(findTestObject('운영/08_병원상세/btn_left', [('text') : '바로접수']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 패널티 팝업이 노출되는 경우 [확인] 버튼 선택'
if(Mobile.waitForElementPresent(findTestObject('운영/09_접수/btn_panalty'), GlobalVariable.waitTime, FailureHandling.CONTINUE_ON_FAILURE))
{
Mobile.tap(findTestObject('운영/09_접수/btn_panalty'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'STEP - [x] 버튼 선택'
Mobile.tap(findTestObject('운영/09_접수/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [아니오] 버튼 선택'
Mobile.tap(findTestObject('운영/09_접수/btn_negativeTxt'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 확인 팝업이 닫힌다.'
Mobile.verifyElementNotVisible(findTestObject('운영/09_접수/btn_negativeTxt'), GlobalVariable.waitTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [x] 버튼 선택'
Mobile.tap(findTestObject('운영/09_접수/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [네] 버튼 선택'
Mobile.tap(findTestObject('운영/09_접수/btn_positiveTxt'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 병원상세 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('운영/08_병원상세/tv_title', [('text') : GlobalVariable.hospital_name]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [바로접수] 버튼 선택'
Mobile.tap(findTestObject('운영/08_병원상세/btn_left', [('text') : '바로접수']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [?] 도움말 버튼 선택'
Mobile.tap(findTestObject('운영/09_접수/btn_iv_option'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 안내 바텀 시트가 노출된다.'
Mobile.verifyElementVisible(findTestObject('운영/09_접수/txt_tv_title', [('text') : '본인과 만 18세 이하 미성년 자녀만']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [확인] 버튼 선택'
Mobile.tap(findTestObject('운영/09_접수/btn_commonBtnTitle', [('text') : '확인']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 진료대상 본인 이름 선택'
Mobile.tap(findTestObject('운영/09_접수/txt_name', [('text') : GlobalVariable.user_name]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [다음] 버튼 선택'
Mobile.tap(findTestObject('운영/09_접수/btn_receiptBtn', [('text') : '다음']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 주민등록 뒷자리 미입력 상태인 경우 뒷자리 입력'
if(Mobile.waitForElementPresent(findTestObject('운영/09_접수/txt_transmission_title'), GlobalVariable.waitTime, FailureHandling.CONTINUE_ON_FAILURE) == true)
{
	'STEP - 주민번호 뒷자리 선택'
	Mobile.tap(findTestObject('운영/09_접수/input_back_number'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'STEP - 주민번호 뒷자리 "1111113" 입력'
	for(i = 1; i <= 6; i++)
	{
		Mobile.tap(findTestObject('운영/10_가족관리/btn_keypad_number', [('text') : '1']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	}
	
	Mobile.tap(findTestObject('운영/10_가족관리/btn_keypad_number', [('text') : '3']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'STEP - [입력 완료] 버튼 선택'
	Mobile.tap(findTestObject('운영/09_접수/btn_finish'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'기대결과 - 진료실 정보에 대기 순서가 노출된다.'
Mobile.verifyElementVisible(findTestObject('운영/09_접수/txt_stateSubMemoTxt', [('text') : '바로 진료 가능']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 진료실 선택'
Mobile.tap(findTestObject('운영/09_접수/txt_name', [('text') : '진료실']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 진료실 공지 노출 시 팝업 닫기'
if(Mobile.waitForElementPresent(findTestObject('운영/00_공통/txt_tvConfirm'), GlobalVariable.waitTime, FailureHandling.CONTINUE_ON_FAILURE))
{
	'STEP - [확인] 버튼 선택'
	Mobile.tap(findTestObject('운영/00_공통/txt_tvConfirm'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'STEP - [이전] 선택'
Mobile.tap(findTestObject('운영/09_접수/btn_prevBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료대상 선택 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('운영/09_접수/txt_name', [('text') : GlobalVariable.user_name]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [다음] 버튼 선택'
Mobile.tap(findTestObject('운영/09_접수/btn_receiptBtn', [('text') : '다음']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 진료실 선택 화면에서 [다음] 선택'
Mobile.tap(findTestObject('운영/09_접수/btn_receiptBtn', [('text') : '다음']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - "결제수단 선택" 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('운영/09_접수/tv_tvPaymentListTitle', [('text') : '결제수단 선택']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 간편결제 수단 선택'
Mobile.tap(findTestObject('운영/09_접수/tv_tvPaymentTitle', [('text') : 'KB국민은행']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [다음] 버튼 선택'
Mobile.tap(findTestObject('운영/09_접수/btn_receiptBtn', [('text') : '다음']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 접수 신청완료 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('운영/09_접수/btn_receiptBtn', [('text') : '동의하고 접수하기']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [이전] 선택'
Mobile.tap(findTestObject('운영/09_접수/btn_prevBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - "결제수단 선택" 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('운영/09_접수/tv_tvPaymentListTitle', [('text') : '결제수단 선택']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [다음] 버튼 선택'
Mobile.tap(findTestObject('운영/09_접수/btn_receiptBtn', [('text') : '다음']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [동의하고 접수하기] 버튼 선택'
Mobile.tap(findTestObject('운영/09_접수/btn_receiptBtn', [('text') : '동의하고 접수하기']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 사전문진 화면이 노출된다.'
Mobile.verifyElementVisible(findTestObject('운영/09_접수/tv_questionnaire', [('text') : ' 사전문진표']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 사전문진 화면 [x] 버튼 선택'
Mobile.tap(findTestObject('운영/09_접수/btn_question_close'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
'STEP - [종료하기] 버튼 선택'
Mobile.tap(findTestObject('운영/09_접수/btn_question_cancel'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('운영/03_홈/btn_menu_home_selected'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 개인화 영역이 노출된다.'
Mobile.verifyElementVisible(findTestObject('운영/03_홈/btn_cl_reception_card'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 개인화 영역 선택'
Mobile.tap(findTestObject('운영/03_홈/btn_cl_reception_card'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료내역 상세 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('운영/00_공통/txt_page_titleTxt', [('text') : '진료내역 상세']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료내역 상세 병원명이 노출된다.'
Mobile.verifyElementText(findTestObject('운영/04_접수내역/txt_detail_hospital'), GlobalVariable.hospital_name, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료내역 상세 진료실명이 노출된다.'
Mobile.verifyElementText(findTestObject('운영/04_접수내역/txt_office'), '진료실', FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료내역 상세 결제수단 정보가 노출된다.'
Mobile.verifyElementVisible(findTestObject('운영/04_접수내역/tv_methodValue', [('text') : '자동결제(토스페이)']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료내역 상세 결제수단 정보가 노출된다.'
Mobile.verifyElementVisible(findTestObject('운영/04_접수내역/tv_methodAdditionalInfo', [('text') : 'KB국민은행']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 접수 상태 문구 저장'
state = Mobile.getText(findTestObject('운영/04_접수내역/txt_stateTxt'), GlobalVariable.waitTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 접수 상태가 "진료 차례"가 아니면 대기'
if(state != '진료 차례')
{
	Mobile.delay(5)
}

'STEP - [접수취소] 버튼 선택'
Mobile.tap(findTestObject('운영/04_접수내역/btn_detail_receipt_cancel'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 확인 팝업 [접수취소] 버튼 선택'
Mobile.tap(findTestObject('운영/00_공통/btn_positiveTxt'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료내역 상세 [접수취소] 버튼이 노출되지 않는다.'
Mobile.verifyElementNotVisible(findTestObject('운영/04_접수내역/btn_detail_receipt_cancel'), GlobalVariable.waitTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료내역 상세 결제수단 정보가 노출되지 않는다.'
Mobile.verifyElementNotVisible(findTestObject('운영/04_접수내역/tv_methodValue', [('text') : '자동결제(토스페이)']), GlobalVariable.waitTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료내역 상세 결제수단 정보가 노출되지 않는다.'
Mobile.verifyElementNotVisible(findTestObject('운영/04_접수내역/tv_methodAdditionalInfo', [('text') : 'KB국민은행']), GlobalVariable.waitTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [<-] 뒤로가기 버튼 선택'
Mobile.tap(findTestObject('운영/00_공통/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('운영/03_홈/btn_menu_home_selected'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 화면에 진료카드가 노출되지 않는다.'
Mobile.verifyElementNotVisible(findTestObject('운영/03_홈/btn_cl_reception_card'), GlobalVariable.waitTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 앱 종료'
try {
	AppiumDriver<?> driver = MobileDriverFactory.getDriver()
	driver.terminateApp(GlobalVariable.appid)

} catch (Exception e) {
}

// 실행 결과 확인
def reader = new BufferedReader(new InputStreamReader(process.inputStream))
def line
while ((line = reader.readLine()) != null) {
	println(line)
}