package api.beans.response;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TokenMechanismsBeanResponse {
	
	private ArrayList<String> Digest;
	private ArrayList<String> FullEncryptDecrypt;
	private ArrayList<String> FullSignVerify;
	private ArrayList<String> KeyDerivation;
	private ArrayList<String> KeyGeneration;
	private ArrayList<String> KeyPairGeneration;
	private ArrayList<String> SignVerifyRecover;
	private ArrayList<String> SingleOperationEncryptDecrypt;
	private ArrayList<String> SingleOperationSignVerify;
	private ArrayList<String> WrapUnwrap;
	
	public TokenMechanismsBeanResponse(){
		this.Digest = new ArrayList<String>();
	    this.FullEncryptDecrypt = new ArrayList<String>();
	    this.FullSignVerify = new ArrayList<String>();
	    this.KeyDerivation = new ArrayList<String>();
	    this.KeyGeneration = new ArrayList<String>();
	    this.KeyPairGeneration = new ArrayList<String>();
	    this.SignVerifyRecover = new ArrayList<String>();
	    this.SingleOperationEncryptDecrypt = new ArrayList<String>();
	    this.SingleOperationSignVerify = new ArrayList<String>();
	    this.WrapUnwrap = new ArrayList<String>();
	}
	

	public ArrayList<String> getDigest() {
		return Digest;
	}
	public ArrayList<String> getFullEncryptDecrypt() {
		return FullEncryptDecrypt;
	}
	public ArrayList<String> getFullSignVerify() {
		return FullSignVerify;
	}
	public ArrayList<String> getKeyDerivation() {
		return KeyDerivation;
	}
	public ArrayList<String> getKeyGeneration() {
		return KeyGeneration;
	}
	public ArrayList<String> getKeyPairGeneration() {
		return KeyPairGeneration;
	}
	public ArrayList<String> getSignVerifyRecover() {
		return SignVerifyRecover;
	}
	public ArrayList<String> getSingleOperationEncryptDecrypt() {
		return SingleOperationEncryptDecrypt;
	}
	public ArrayList<String> getSingleOperationSignVerify() {
		return SingleOperationSignVerify;
	}
	public ArrayList<String> getWrapUnwrap() {
		return WrapUnwrap;
	}
	


	public void setFullEncryptDecrypt(ArrayList<String> fullEncryptDecrypt) {
		FullEncryptDecrypt = fullEncryptDecrypt;
	}


	public void setFullSignVerify(ArrayList<String> fullSignVerify) {
		FullSignVerify = fullSignVerify;
	}


	public void setKeyDerivation(ArrayList<String> keyDerivation) {
		KeyDerivation = keyDerivation;
	}


	public void setKeyGeneration(ArrayList<String> keyGeneration) {
		KeyGeneration = keyGeneration;
	}


	public void setKeyPairGeneration(ArrayList<String> keyPairGeneration) {
		KeyPairGeneration = keyPairGeneration;
	}


	public void setSignVerifyRecover(ArrayList<String> signVerifyRecover) {
		SignVerifyRecover = signVerifyRecover;
	}


	public void setSingleOperationEncryptDecrypt(ArrayList<String> singleOperationEncryptDecrypt) {
		SingleOperationEncryptDecrypt = singleOperationEncryptDecrypt;
	}


	public void setSingleOperationSignVerify(ArrayList<String> singleOperationSignVerify) {
		SingleOperationSignVerify = singleOperationSignVerify;
	}


	public void setWrapUnwrap(ArrayList<String> wrapUnwrap) {
		WrapUnwrap = wrapUnwrap;
	}



	public void addDigest(String s){
	    Digest.add(s);
	}
	public void clearDigest(){
	    Digest.clear();
	}
	public void addFullEncryptDecrypt(String s){
	    FullEncryptDecrypt.add(s);
	}
	public void setDigest(ArrayList<String> digest) {
		Digest = digest;
	}
	public void clearFullEncryptDecrypt(){
	    FullEncryptDecrypt.clear();
	}
	public void addFullSignVerify(String s){
	    FullSignVerify.add(s);
	}
	public void clearFullSignVerify(){
	    FullSignVerify.clear();
	}
	public void addKeyDerivation(String s){
	    KeyDerivation.add(s);
	}
	public void clearKeyDerivation(){
	    KeyDerivation.clear();
	}
	public void addKeyGeneration(String s){
	    KeyGeneration.add(s);
	}
	public void clearKeyGeneration(){
	    KeyGeneration.clear();
	}
	public void addKeyPairGeneration(String s){
	    KeyPairGeneration.add(s);
	}
	public void clearKeyPairGeneration(){
	    KeyPairGeneration.clear();
	}
	public void addSignVerifyRecover(String s){
	    SignVerifyRecover.add(s);
	}
	public void clearSignVerifyRecover(){
	    SignVerifyRecover.clear();
	}
	public void addSingleOperationEncryptDecrypt(String s){
	    SingleOperationEncryptDecrypt.add(s);
	}
	public void clearSingleOperationEncryptDecrypt(){
	    SingleOperationEncryptDecrypt.clear();
	}
	public void addSingleOperationSignVerify(String s){
	    SingleOperationSignVerify.add(s);
	}
	public void clearSingleOperationSignVerify(){
	    SingleOperationSignVerify.clear();
	}
	public void addWrapUnwrap(String s){
	    WrapUnwrap.add(s);
	}
	public void clearWrapUnwrap(){
	    WrapUnwrap.clear();
	}


}
