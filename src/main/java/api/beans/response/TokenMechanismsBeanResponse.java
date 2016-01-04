package api.beans.response;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TokenMechanismsBeanResponse {
	private boolean AES_CBC;
	private boolean AES_CBC_ENCRYPT_DATA;
	private boolean AES_CBC_PAD;
	private boolean AES_ECB;
	private boolean AES_ECB_ENCRYPT_DATA;
	private boolean AES_KEY_GEN;
	private boolean AES_MAC;
	private boolean AES_MAC_GENERAL;
	private boolean BATON_CBC128;
	private boolean BATON_COUNTER;
	private boolean BATON_ECB128;
	private boolean BATON_ECB96;
	private boolean BATON_KEY_GEN;
	private boolean BATON_SHUFFLE;
	private boolean BATON_WRAP;
	private boolean BLOWFISH_CBC;
	private boolean BLOWFISH_KEY_GEN;
	private boolean CAST_CBC;
	private boolean CAST_CBC_PAD;
	private boolean CAST_ECB;
	private boolean CAST_KEY_GEN;
	private boolean CAST_MAC;
	private boolean CAST_MAC_GENERAL;
	private boolean CAST128_CBC;
	private boolean CAST128_CBC_PAD;
	private boolean CAST128_ECB;
	private boolean CAST128_KEY_GEN;
	private boolean CAST128_MAC;
	private boolean CAST128_MAC_GENERAL;
	private boolean CAST3_CBC;
	private boolean CAST3_CBC_PAD;
	private boolean CAST3_ECB;
	private boolean CAST3_KEY_GEN;
	private boolean CAST3_MAC;
	private boolean CAST3_MAC_GENERAL;
	private boolean CAST5_CBC;
	private boolean CAST5_CBC_PAD;
	private boolean CAST5_ECB;
	private boolean CAST5_KEY_GEN;
	private boolean CAST5_MAC;
	private boolean CAST5_MAC_GENERAL;
	private boolean CDMF_CBC;
	private boolean CDMF_CBC_PAD;
	private boolean CDMF_ECB;
	private boolean CDMF_KEY_GEN;
	private boolean CDMF_MAC;
	private boolean CDMF_MAC_GENERAL;
	private boolean CONCATENATE_BASE_AND_DATA;
	private boolean CONCATENATE_BASE_AND_KEY;
	private boolean CONCATENATE_DATA_AND_BASE;
	private boolean DES_CBC;
	private boolean DES_CBC_ENCRYPT_DATA;
	private boolean DES_CBC_PAD;
	private boolean DES_CFB64;
	private boolean DES_CFB8;
	private boolean DES_ECB;
	private boolean DES_ECB_ENCRYPT_DATA;
	private boolean DES_KEY_GEN;
	private boolean DES_MAC;
	private boolean DES_MAC_GENERAL;
	private boolean DES_OFB64;
	private boolean DES_OFB8;
	private boolean DES2_KEY_GEN;
	private boolean DES3_CBC;
	private boolean DES3_CBC_ENCRYPT_DATA;
	private boolean DES3_CBC_PAD;
	private boolean DES3_ECB;
	private boolean DES3_ECB_ENCRYPT_DATA;
	private boolean DES3_KEY_GEN;
	private boolean DES3_MAC;
	private boolean DES3_MAC_GENERAL;
	private boolean DH_PKCS_DERIVE;
	private boolean DH_PKCS_KEY_PAIR_GEN;
	private boolean DH_PKCS_PARAMETER_GEN;
	private boolean DSA;
	private boolean DSA_KEY_PAIR_GEN;
	private boolean DSA_PARAMETER_GEN;
	private boolean DSA_SHA1;
	private boolean EC_KEY_PAIR_GEN;
	private boolean ECDH1_COFACTOR_DERIVE;
	private boolean ECDH1_DERIVE;
	private boolean ECDSA;
	private boolean ECDSA_KEY_PAIR_GEN;
	private boolean ECDSA_SHA1;
	private boolean ECMQV_DERIVE;
	private boolean EXTRACT_KEY_FROM_KEY;
	private boolean FASTHASH;
	private boolean FORTEZZA_TIMESTAMP;
	private boolean GENERIC_SECRET_KEY_GEN;
	private boolean IDEA_CBC;
	private boolean IDEA_CBC_PAD;
	private boolean IDEA_ECB;
	private boolean IDEA_KEY_GEN;
	private boolean IDEA_MAC;
	private boolean IDEA_MAC_GENERAL;
	private boolean JUNIPER_CBC128;
	private boolean JUNIPER_COUNTER;
	private boolean JUNIPER_ECB128;
	private boolean JUNIPER_KEY_GEN;
	private boolean JUNIPER_SHUFFLE;
	private boolean JUNIPER_WRAP;
	private boolean KEA_KEY_DERIVE;
	private boolean KEA_KEY_PAIR_GEN;
	private boolean KEY_WRAP_LYNKS;
	private boolean KEY_WRAP_SET_OAEP;
	private boolean MD2;
	private boolean MD2_HMAC;
	private boolean MD2_HMAC_GENERAL;
	private boolean MD2_KEY_DERIVATION;
	private boolean MD2_RSA_PKCS;
	private boolean MD5;
	private boolean MD5_HMAC;
	private boolean MD5_HMAC_GENERAL;
	private boolean MD5_KEY_DERIVATION;
	private boolean MD5_RSA_PKCS;
	private boolean PBA_SHA1_WITH_SHA1_HMAC;
	private boolean PBE_MD2_DES_CBC;
	private boolean PBE_MD5_CAST_CBC;
	private boolean PBE_MD5_CAST128_CBC;
	private boolean PBE_MD5_CAST3_CBC;
	private boolean PBE_MD5_CAST5_CBC;
	private boolean PBE_MD5_DES_CBC;
	private boolean PBE_SHA1_CAST128_CBC;
	private boolean PBE_SHA1_CAST5_CBC;
	private boolean PBE_SHA1_DES2_EDE_CBC;
	private boolean PBE_SHA1_DES3_EDE_CBC;
	private boolean PBE_SHA1_RC2_128_CBC;
	private boolean PBE_SHA1_RC2_40_CBC;
	private boolean PBE_SHA1_RC4_128;
	private boolean PBE_SHA1_RC4_40;
	private boolean PKCS5_PBKD2;
	private boolean RC2_CBC;
	private boolean RC2_CBC_PAD;
	private boolean RC2_ECB;
	private boolean RC2_KEY_GEN;
	private boolean RC2_MAC;
	private boolean RC2_MAC_GENERAL;
	private boolean RC4;
	private boolean RC4_KEY_GEN;
	private boolean RC5_CBC;
	private boolean RC5_CBC_PAD;
	private boolean RC5_ECB;
	private boolean RC5_KEY_GEN;
	private boolean RC5_MAC;
	private boolean RC5_MAC_GENERAL;
	private boolean RIPEMD128;
	private boolean RIPEMD128_HMAC;
	private boolean RIPEMD128_HMAC_GENERAL;
	private boolean RIPEMD128_RSA_PKCS;
	private boolean RIPEMD160;
	private boolean RIPEMD160_HMAC;
	private boolean RIPEMD160_HMAC_GENERAL;
	private boolean RIPEMD160_RSA_PKCS;
	private boolean RSA_9796;
	private boolean RSA_PKCS;
	private boolean RSA_PKCS_KEY_PAIR_GEN;
	private boolean RSA_PKCS_OAEP;
	private boolean RSA_PKCS_PSS;
	private boolean RSA_X_509;
	private boolean RSA_X9_31;
	private boolean RSA_X9_31_KEY_PAIR_GEN;
	private boolean SHA_1;
	private boolean SHA_1_HMAC;
	private boolean SHA_1_HMAC_GENERAL;
	private boolean SHA1_KEY_DERIVATION;
	private boolean SHA1_RSA_PKCS;
	private boolean SHA1_RSA_PKCS_PSS;
	private boolean SHA1_RSA_X9_31;
	private boolean SHA256;
	private boolean SHA256_HMAC;
	private boolean SHA256_HMAC_GENERAL;
	private boolean SHA256_KEY_DERIVATION;
	private boolean SHA256_RSA_PKCS;
	private boolean SHA256_RSA_PKCS_PSS;
	private boolean SHA384;
	private boolean SHA384_HMAC;
	private boolean SHA384_HMAC_GENERAL;
	private boolean SHA384_KEY_DERIVATION;
	private boolean SHA384_RSA_PKCS;
	private boolean SHA384_RSA_PKCS_PSS;
	private boolean SHA512;
	private boolean SHA512_HMAC;
	private boolean SHA512_HMAC_GENERAL;
	private boolean SHA512_KEY_DERIVATION;
	private boolean SHA512_RSA_PKCS;
	private boolean SHA512_RSA_PKCS_PSS;
	private boolean SKIPJACK_CBC64;
	private boolean SKIPJACK_CFB16;
	private boolean SKIPJACK_CFB32;
	private boolean SKIPJACK_CFB64;
	private boolean SKIPJACK_CFB8;
	private boolean SKIPJACK_ECB64;
	private boolean SKIPJACK_KEY_GEN;
	private boolean SKIPJACK_OFB64;
	private boolean SKIPJACK_PRIVATE_WRAP;
	private boolean SKIPJACK_RELAYX;
	private boolean SKIPJACK_WRAP;
	private boolean SSL3_KEY_AND_MAC_DERIVE;
	private boolean SSL3_MASTER_KEY_DERIVE;
	private boolean SSL3_MASTER_KEY_DERIVE_DH;
	private boolean SSL3_MD5_MAC;
	private boolean SSL3_PRE_MASTER_KEY_GEN;
	private boolean SSL3_SHA1_MAC;
	private boolean TLS_KEY_AND_MAC_DERIVE;
	private boolean TLS_MASTER_KEY_DERIVE;
	private boolean TLS_MASTER_KEY_DERIVE_DH;
	private boolean TLS_PRE_MASTER_KEY_GEN;
	private boolean TLS_PRF;
	private boolean VENDOR_DEFINED;
	private boolean WTLS_CLIENT_KEY_AND_MAC_DERIVE;
	private boolean WTLS_MASTER_KEY_DERIVE;
	private boolean WTLS_MASTER_KEY_DERIVE_DH_ECC;
	private boolean WTLS_PRE_MASTER_KEY_GEN;
	private boolean WTLS_PRF;
	private boolean WTLS_SERVER_KEY_AND_MAC_DERIVE;
	private boolean X9_42_DH_DERIVE;
	private boolean X9_42_DH_HYBRID_DERIVE;
	private boolean X9_42_DH_KEY_PAIR_GEN;
	private boolean X9_42_DH_PARAMETER_GEN;
	private boolean X9_42_MQV_DERIVE;
	private boolean XOR_BASE_AND_DATA;

	public boolean isAES_CBC () {
	    return  AES_CBC;
	}
	public void setAES_CBC (boolean iAES_CBC) {
	    AES_CBC = iAES_CBC;
	}

	public boolean isAES_CBC_ENCRYPT_DATA () {
	    return  AES_CBC_ENCRYPT_DATA;
	}
	public void setAES_CBC_ENCRYPT_DATA (boolean iAES_CBC_ENCRYPT_DATA) {
	    AES_CBC_ENCRYPT_DATA = iAES_CBC_ENCRYPT_DATA;
	}

	public boolean isAES_CBC_PAD () {
	    return  AES_CBC_PAD;
	}
	public void setAES_CBC_PAD (boolean iAES_CBC_PAD) {
	    AES_CBC_PAD = iAES_CBC_PAD;
	}

	public boolean isAES_ECB () {
	    return  AES_ECB;
	}
	public void setAES_ECB (boolean iAES_ECB) {
	    AES_ECB = iAES_ECB;
	}

	public boolean isAES_ECB_ENCRYPT_DATA () {
	    return  AES_ECB_ENCRYPT_DATA;
	}
	public void setAES_ECB_ENCRYPT_DATA (boolean iAES_ECB_ENCRYPT_DATA) {
	    AES_ECB_ENCRYPT_DATA = iAES_ECB_ENCRYPT_DATA;
	}

	public boolean isAES_KEY_GEN () {
	    return  AES_KEY_GEN;
	}
	public void setAES_KEY_GEN (boolean iAES_KEY_GEN) {
	    AES_KEY_GEN = iAES_KEY_GEN;
	}

	public boolean isAES_MAC () {
	    return  AES_MAC;
	}
	public void setAES_MAC (boolean iAES_MAC) {
	    AES_MAC = iAES_MAC;
	}

	public boolean isAES_MAC_GENERAL () {
	    return  AES_MAC_GENERAL;
	}
	public void setAES_MAC_GENERAL (boolean iAES_MAC_GENERAL) {
	    AES_MAC_GENERAL = iAES_MAC_GENERAL;
	}

	public boolean isBATON_CBC128 () {
	    return  BATON_CBC128;
	}
	public void setBATON_CBC128 (boolean iBATON_CBC128) {
	    BATON_CBC128 = iBATON_CBC128;
	}

	public boolean isBATON_COUNTER () {
	    return  BATON_COUNTER;
	}
	public void setBATON_COUNTER (boolean iBATON_COUNTER) {
	    BATON_COUNTER = iBATON_COUNTER;
	}

	public boolean isBATON_ECB128 () {
	    return  BATON_ECB128;
	}
	public void setBATON_ECB128 (boolean iBATON_ECB128) {
	    BATON_ECB128 = iBATON_ECB128;
	}

	public boolean isBATON_ECB96 () {
	    return  BATON_ECB96;
	}
	public void setBATON_ECB96 (boolean iBATON_ECB96) {
	    BATON_ECB96 = iBATON_ECB96;
	}

	public boolean isBATON_KEY_GEN () {
	    return  BATON_KEY_GEN;
	}
	public void setBATON_KEY_GEN (boolean iBATON_KEY_GEN) {
	    BATON_KEY_GEN = iBATON_KEY_GEN;
	}

	public boolean isBATON_SHUFFLE () {
	    return  BATON_SHUFFLE;
	}
	public void setBATON_SHUFFLE (boolean iBATON_SHUFFLE) {
	    BATON_SHUFFLE = iBATON_SHUFFLE;
	}

	public boolean isBATON_WRAP () {
	    return  BATON_WRAP;
	}
	public void setBATON_WRAP (boolean iBATON_WRAP) {
	    BATON_WRAP = iBATON_WRAP;
	}

	public boolean isBLOWFISH_CBC () {
	    return  BLOWFISH_CBC;
	}
	public void setBLOWFISH_CBC (boolean iBLOWFISH_CBC) {
	    BLOWFISH_CBC = iBLOWFISH_CBC;
	}

	public boolean isBLOWFISH_KEY_GEN () {
	    return  BLOWFISH_KEY_GEN;
	}
	public void setBLOWFISH_KEY_GEN (boolean iBLOWFISH_KEY_GEN) {
	    BLOWFISH_KEY_GEN = iBLOWFISH_KEY_GEN;
	}

	public boolean isCAST_CBC () {
	    return  CAST_CBC;
	}
	public void setCAST_CBC (boolean iCAST_CBC) {
	    CAST_CBC = iCAST_CBC;
	}

	public boolean isCAST_CBC_PAD () {
	    return  CAST_CBC_PAD;
	}
	public void setCAST_CBC_PAD (boolean iCAST_CBC_PAD) {
	    CAST_CBC_PAD = iCAST_CBC_PAD;
	}

	public boolean isCAST_ECB () {
	    return  CAST_ECB;
	}
	public void setCAST_ECB (boolean iCAST_ECB) {
	    CAST_ECB = iCAST_ECB;
	}

	public boolean isCAST_KEY_GEN () {
	    return  CAST_KEY_GEN;
	}
	public void setCAST_KEY_GEN (boolean iCAST_KEY_GEN) {
	    CAST_KEY_GEN = iCAST_KEY_GEN;
	}

	public boolean isCAST_MAC () {
	    return  CAST_MAC;
	}
	public void setCAST_MAC (boolean iCAST_MAC) {
	    CAST_MAC = iCAST_MAC;
	}

	public boolean isCAST_MAC_GENERAL () {
	    return  CAST_MAC_GENERAL;
	}
	public void setCAST_MAC_GENERAL (boolean iCAST_MAC_GENERAL) {
	    CAST_MAC_GENERAL = iCAST_MAC_GENERAL;
	}

	public boolean isCAST128_CBC () {
	    return  CAST128_CBC;
	}
	public void setCAST128_CBC (boolean iCAST128_CBC) {
	    CAST128_CBC = iCAST128_CBC;
	}

	public boolean isCAST128_CBC_PAD () {
	    return  CAST128_CBC_PAD;
	}
	public void setCAST128_CBC_PAD (boolean iCAST128_CBC_PAD) {
	    CAST128_CBC_PAD = iCAST128_CBC_PAD;
	}

	public boolean isCAST128_ECB () {
	    return  CAST128_ECB;
	}
	public void setCAST128_ECB (boolean iCAST128_ECB) {
	    CAST128_ECB = iCAST128_ECB;
	}

	public boolean isCAST128_KEY_GEN () {
	    return  CAST128_KEY_GEN;
	}
	public void setCAST128_KEY_GEN (boolean iCAST128_KEY_GEN) {
	    CAST128_KEY_GEN = iCAST128_KEY_GEN;
	}

	public boolean isCAST128_MAC () {
	    return  CAST128_MAC;
	}
	public void setCAST128_MAC (boolean iCAST128_MAC) {
	    CAST128_MAC = iCAST128_MAC;
	}

	public boolean isCAST128_MAC_GENERAL () {
	    return  CAST128_MAC_GENERAL;
	}
	public void setCAST128_MAC_GENERAL (boolean iCAST128_MAC_GENERAL) {
	    CAST128_MAC_GENERAL = iCAST128_MAC_GENERAL;
	}

	public boolean isCAST3_CBC () {
	    return  CAST3_CBC;
	}
	public void setCAST3_CBC (boolean iCAST3_CBC) {
	    CAST3_CBC = iCAST3_CBC;
	}

	public boolean isCAST3_CBC_PAD () {
	    return  CAST3_CBC_PAD;
	}
	public void setCAST3_CBC_PAD (boolean iCAST3_CBC_PAD) {
	    CAST3_CBC_PAD = iCAST3_CBC_PAD;
	}

	public boolean isCAST3_ECB () {
	    return  CAST3_ECB;
	}
	public void setCAST3_ECB (boolean iCAST3_ECB) {
	    CAST3_ECB = iCAST3_ECB;
	}

	public boolean isCAST3_KEY_GEN () {
	    return  CAST3_KEY_GEN;
	}
	public void setCAST3_KEY_GEN (boolean iCAST3_KEY_GEN) {
	    CAST3_KEY_GEN = iCAST3_KEY_GEN;
	}

	public boolean isCAST3_MAC () {
	    return  CAST3_MAC;
	}
	public void setCAST3_MAC (boolean iCAST3_MAC) {
	    CAST3_MAC = iCAST3_MAC;
	}

	public boolean isCAST3_MAC_GENERAL () {
	    return  CAST3_MAC_GENERAL;
	}
	public void setCAST3_MAC_GENERAL (boolean iCAST3_MAC_GENERAL) {
	    CAST3_MAC_GENERAL = iCAST3_MAC_GENERAL;
	}

	public boolean isCAST5_CBC () {
	    return  CAST5_CBC;
	}
	public void setCAST5_CBC (boolean iCAST5_CBC) {
	    CAST5_CBC = iCAST5_CBC;
	}

	public boolean isCAST5_CBC_PAD () {
	    return  CAST5_CBC_PAD;
	}
	public void setCAST5_CBC_PAD (boolean iCAST5_CBC_PAD) {
	    CAST5_CBC_PAD = iCAST5_CBC_PAD;
	}

	public boolean isCAST5_ECB () {
	    return  CAST5_ECB;
	}
	public void setCAST5_ECB (boolean iCAST5_ECB) {
	    CAST5_ECB = iCAST5_ECB;
	}

	public boolean isCAST5_KEY_GEN () {
	    return  CAST5_KEY_GEN;
	}
	public void setCAST5_KEY_GEN (boolean iCAST5_KEY_GEN) {
	    CAST5_KEY_GEN = iCAST5_KEY_GEN;
	}

	public boolean isCAST5_MAC () {
	    return  CAST5_MAC;
	}
	public void setCAST5_MAC (boolean iCAST5_MAC) {
	    CAST5_MAC = iCAST5_MAC;
	}

	public boolean isCAST5_MAC_GENERAL () {
	    return  CAST5_MAC_GENERAL;
	}
	public void setCAST5_MAC_GENERAL (boolean iCAST5_MAC_GENERAL) {
	    CAST5_MAC_GENERAL = iCAST5_MAC_GENERAL;
	}

	public boolean isCDMF_CBC () {
	    return  CDMF_CBC;
	}
	public void setCDMF_CBC (boolean iCDMF_CBC) {
	    CDMF_CBC = iCDMF_CBC;
	}

	public boolean isCDMF_CBC_PAD () {
	    return  CDMF_CBC_PAD;
	}
	public void setCDMF_CBC_PAD (boolean iCDMF_CBC_PAD) {
	    CDMF_CBC_PAD = iCDMF_CBC_PAD;
	}

	public boolean isCDMF_ECB () {
	    return  CDMF_ECB;
	}
	public void setCDMF_ECB (boolean iCDMF_ECB) {
	    CDMF_ECB = iCDMF_ECB;
	}

	public boolean isCDMF_KEY_GEN () {
	    return  CDMF_KEY_GEN;
	}
	public void setCDMF_KEY_GEN (boolean iCDMF_KEY_GEN) {
	    CDMF_KEY_GEN = iCDMF_KEY_GEN;
	}

	public boolean isCDMF_MAC () {
	    return  CDMF_MAC;
	}
	public void setCDMF_MAC (boolean iCDMF_MAC) {
	    CDMF_MAC = iCDMF_MAC;
	}

	public boolean isCDMF_MAC_GENERAL () {
	    return  CDMF_MAC_GENERAL;
	}
	public void setCDMF_MAC_GENERAL (boolean iCDMF_MAC_GENERAL) {
	    CDMF_MAC_GENERAL = iCDMF_MAC_GENERAL;
	}

	public boolean isCONCATENATE_BASE_AND_DATA () {
	    return  CONCATENATE_BASE_AND_DATA;
	}
	public void setCONCATENATE_BASE_AND_DATA (boolean iCONCATENATE_BASE_AND_DATA) {
	    CONCATENATE_BASE_AND_DATA = iCONCATENATE_BASE_AND_DATA;
	}

	public boolean isCONCATENATE_BASE_AND_KEY () {
	    return  CONCATENATE_BASE_AND_KEY;
	}
	public void setCONCATENATE_BASE_AND_KEY (boolean iCONCATENATE_BASE_AND_KEY) {
	    CONCATENATE_BASE_AND_KEY = iCONCATENATE_BASE_AND_KEY;
	}

	public boolean isCONCATENATE_DATA_AND_BASE () {
	    return  CONCATENATE_DATA_AND_BASE;
	}
	public void setCONCATENATE_DATA_AND_BASE (boolean iCONCATENATE_DATA_AND_BASE) {
	    CONCATENATE_DATA_AND_BASE = iCONCATENATE_DATA_AND_BASE;
	}

	public boolean isDES_CBC () {
	    return  DES_CBC;
	}
	public void setDES_CBC (boolean iDES_CBC) {
	    DES_CBC = iDES_CBC;
	}

	public boolean isDES_CBC_ENCRYPT_DATA () {
	    return  DES_CBC_ENCRYPT_DATA;
	}
	public void setDES_CBC_ENCRYPT_DATA (boolean iDES_CBC_ENCRYPT_DATA) {
	    DES_CBC_ENCRYPT_DATA = iDES_CBC_ENCRYPT_DATA;
	}

	public boolean isDES_CBC_PAD () {
	    return  DES_CBC_PAD;
	}
	public void setDES_CBC_PAD (boolean iDES_CBC_PAD) {
	    DES_CBC_PAD = iDES_CBC_PAD;
	}

	public boolean isDES_CFB64 () {
	    return  DES_CFB64;
	}
	public void setDES_CFB64 (boolean iDES_CFB64) {
	    DES_CFB64 = iDES_CFB64;
	}

	public boolean isDES_CFB8 () {
	    return  DES_CFB8;
	}
	public void setDES_CFB8 (boolean iDES_CFB8) {
	    DES_CFB8 = iDES_CFB8;
	}

	public boolean isDES_ECB () {
	    return  DES_ECB;
	}
	public void setDES_ECB (boolean iDES_ECB) {
	    DES_ECB = iDES_ECB;
	}

	public boolean isDES_ECB_ENCRYPT_DATA () {
	    return  DES_ECB_ENCRYPT_DATA;
	}
	public void setDES_ECB_ENCRYPT_DATA (boolean iDES_ECB_ENCRYPT_DATA) {
	    DES_ECB_ENCRYPT_DATA = iDES_ECB_ENCRYPT_DATA;
	}

	public boolean isDES_KEY_GEN () {
	    return  DES_KEY_GEN;
	}
	public void setDES_KEY_GEN (boolean iDES_KEY_GEN) {
	    DES_KEY_GEN = iDES_KEY_GEN;
	}

	public boolean isDES_MAC () {
	    return  DES_MAC;
	}
	public void setDES_MAC (boolean iDES_MAC) {
	    DES_MAC = iDES_MAC;
	}

	public boolean isDES_MAC_GENERAL () {
	    return  DES_MAC_GENERAL;
	}
	public void setDES_MAC_GENERAL (boolean iDES_MAC_GENERAL) {
	    DES_MAC_GENERAL = iDES_MAC_GENERAL;
	}

	public boolean isDES_OFB64 () {
	    return  DES_OFB64;
	}
	public void setDES_OFB64 (boolean iDES_OFB64) {
	    DES_OFB64 = iDES_OFB64;
	}

	public boolean isDES_OFB8 () {
	    return  DES_OFB8;
	}
	public void setDES_OFB8 (boolean iDES_OFB8) {
	    DES_OFB8 = iDES_OFB8;
	}

	public boolean isDES2_KEY_GEN () {
	    return  DES2_KEY_GEN;
	}
	public void setDES2_KEY_GEN (boolean iDES2_KEY_GEN) {
	    DES2_KEY_GEN = iDES2_KEY_GEN;
	}

	public boolean isDES3_CBC () {
	    return  DES3_CBC;
	}
	public void setDES3_CBC (boolean iDES3_CBC) {
	    DES3_CBC = iDES3_CBC;
	}

	public boolean isDES3_CBC_ENCRYPT_DATA () {
	    return  DES3_CBC_ENCRYPT_DATA;
	}
	public void setDES3_CBC_ENCRYPT_DATA (boolean iDES3_CBC_ENCRYPT_DATA) {
	    DES3_CBC_ENCRYPT_DATA = iDES3_CBC_ENCRYPT_DATA;
	}

	public boolean isDES3_CBC_PAD () {
	    return  DES3_CBC_PAD;
	}
	public void setDES3_CBC_PAD (boolean iDES3_CBC_PAD) {
	    DES3_CBC_PAD = iDES3_CBC_PAD;
	}

	public boolean isDES3_ECB () {
	    return  DES3_ECB;
	}
	public void setDES3_ECB (boolean iDES3_ECB) {
	    DES3_ECB = iDES3_ECB;
	}

	public boolean isDES3_ECB_ENCRYPT_DATA () {
	    return  DES3_ECB_ENCRYPT_DATA;
	}
	public void setDES3_ECB_ENCRYPT_DATA (boolean iDES3_ECB_ENCRYPT_DATA) {
	    DES3_ECB_ENCRYPT_DATA = iDES3_ECB_ENCRYPT_DATA;
	}

	public boolean isDES3_KEY_GEN () {
	    return  DES3_KEY_GEN;
	}
	public void setDES3_KEY_GEN (boolean iDES3_KEY_GEN) {
	    DES3_KEY_GEN = iDES3_KEY_GEN;
	}

	public boolean isDES3_MAC () {
	    return  DES3_MAC;
	}
	public void setDES3_MAC (boolean iDES3_MAC) {
	    DES3_MAC = iDES3_MAC;
	}

	public boolean isDES3_MAC_GENERAL () {
	    return  DES3_MAC_GENERAL;
	}
	public void setDES3_MAC_GENERAL (boolean iDES3_MAC_GENERAL) {
	    DES3_MAC_GENERAL = iDES3_MAC_GENERAL;
	}

	public boolean isDH_PKCS_DERIVE () {
	    return  DH_PKCS_DERIVE;
	}
	public void setDH_PKCS_DERIVE (boolean iDH_PKCS_DERIVE) {
	    DH_PKCS_DERIVE = iDH_PKCS_DERIVE;
	}

	public boolean isDH_PKCS_KEY_PAIR_GEN () {
	    return  DH_PKCS_KEY_PAIR_GEN;
	}
	public void setDH_PKCS_KEY_PAIR_GEN (boolean iDH_PKCS_KEY_PAIR_GEN) {
	    DH_PKCS_KEY_PAIR_GEN = iDH_PKCS_KEY_PAIR_GEN;
	}

	public boolean isDH_PKCS_PARAMETER_GEN () {
	    return  DH_PKCS_PARAMETER_GEN;
	}
	public void setDH_PKCS_PARAMETER_GEN (boolean iDH_PKCS_PARAMETER_GEN) {
	    DH_PKCS_PARAMETER_GEN = iDH_PKCS_PARAMETER_GEN;
	}

	public boolean isDSA () {
	    return  DSA;
	}
	public void setDSA (boolean iDSA) {
	    DSA = iDSA;
	}

	public boolean isDSA_KEY_PAIR_GEN () {
	    return  DSA_KEY_PAIR_GEN;
	}
	public void setDSA_KEY_PAIR_GEN (boolean iDSA_KEY_PAIR_GEN) {
	    DSA_KEY_PAIR_GEN = iDSA_KEY_PAIR_GEN;
	}

	public boolean isDSA_PARAMETER_GEN () {
	    return  DSA_PARAMETER_GEN;
	}
	public void setDSA_PARAMETER_GEN (boolean iDSA_PARAMETER_GEN) {
	    DSA_PARAMETER_GEN = iDSA_PARAMETER_GEN;
	}

	public boolean isDSA_SHA1 () {
	    return  DSA_SHA1;
	}
	public void setDSA_SHA1 (boolean iDSA_SHA1) {
	    DSA_SHA1 = iDSA_SHA1;
	}

	public boolean isEC_KEY_PAIR_GEN () {
	    return  EC_KEY_PAIR_GEN;
	}
	public void setEC_KEY_PAIR_GEN (boolean iEC_KEY_PAIR_GEN) {
	    EC_KEY_PAIR_GEN = iEC_KEY_PAIR_GEN;
	}

	public boolean isECDH1_COFACTOR_DERIVE () {
	    return  ECDH1_COFACTOR_DERIVE;
	}
	public void setECDH1_COFACTOR_DERIVE (boolean iECDH1_COFACTOR_DERIVE) {
	    ECDH1_COFACTOR_DERIVE = iECDH1_COFACTOR_DERIVE;
	}

	public boolean isECDH1_DERIVE () {
	    return  ECDH1_DERIVE;
	}
	public void setECDH1_DERIVE (boolean iECDH1_DERIVE) {
	    ECDH1_DERIVE = iECDH1_DERIVE;
	}

	public boolean isECDSA () {
	    return  ECDSA;
	}
	public void setECDSA (boolean iECDSA) {
	    ECDSA = iECDSA;
	}

	public boolean isECDSA_KEY_PAIR_GEN () {
	    return  ECDSA_KEY_PAIR_GEN;
	}
	public void setECDSA_KEY_PAIR_GEN (boolean iECDSA_KEY_PAIR_GEN) {
	    ECDSA_KEY_PAIR_GEN = iECDSA_KEY_PAIR_GEN;
	}

	public boolean isECDSA_SHA1 () {
	    return  ECDSA_SHA1;
	}
	public void setECDSA_SHA1 (boolean iECDSA_SHA1) {
	    ECDSA_SHA1 = iECDSA_SHA1;
	}

	public boolean isECMQV_DERIVE () {
	    return  ECMQV_DERIVE;
	}
	public void setECMQV_DERIVE (boolean iECMQV_DERIVE) {
	    ECMQV_DERIVE = iECMQV_DERIVE;
	}

	public boolean isEXTRACT_KEY_FROM_KEY () {
	    return  EXTRACT_KEY_FROM_KEY;
	}
	public void setEXTRACT_KEY_FROM_KEY (boolean iEXTRACT_KEY_FROM_KEY) {
	    EXTRACT_KEY_FROM_KEY = iEXTRACT_KEY_FROM_KEY;
	}

	public boolean isFASTHASH () {
	    return  FASTHASH;
	}
	public void setFASTHASH (boolean iFASTHASH) {
	    FASTHASH = iFASTHASH;
	}

	public boolean isFORTEZZA_TIMESTAMP () {
	    return  FORTEZZA_TIMESTAMP;
	}
	public void setFORTEZZA_TIMESTAMP (boolean iFORTEZZA_TIMESTAMP) {
	    FORTEZZA_TIMESTAMP = iFORTEZZA_TIMESTAMP;
	}

	public boolean isGENERIC_SECRET_KEY_GEN () {
	    return  GENERIC_SECRET_KEY_GEN;
	}
	public void setGENERIC_SECRET_KEY_GEN (boolean iGENERIC_SECRET_KEY_GEN) {
	    GENERIC_SECRET_KEY_GEN = iGENERIC_SECRET_KEY_GEN;
	}

	public boolean isIDEA_CBC () {
	    return  IDEA_CBC;
	}
	public void setIDEA_CBC (boolean iIDEA_CBC) {
	    IDEA_CBC = iIDEA_CBC;
	}

	public boolean isIDEA_CBC_PAD () {
	    return  IDEA_CBC_PAD;
	}
	public void setIDEA_CBC_PAD (boolean iIDEA_CBC_PAD) {
	    IDEA_CBC_PAD = iIDEA_CBC_PAD;
	}

	public boolean isIDEA_ECB () {
	    return  IDEA_ECB;
	}
	public void setIDEA_ECB (boolean iIDEA_ECB) {
	    IDEA_ECB = iIDEA_ECB;
	}

	public boolean isIDEA_KEY_GEN () {
	    return  IDEA_KEY_GEN;
	}
	public void setIDEA_KEY_GEN (boolean iIDEA_KEY_GEN) {
	    IDEA_KEY_GEN = iIDEA_KEY_GEN;
	}

	public boolean isIDEA_MAC () {
	    return  IDEA_MAC;
	}
	public void setIDEA_MAC (boolean iIDEA_MAC) {
	    IDEA_MAC = iIDEA_MAC;
	}

	public boolean isIDEA_MAC_GENERAL () {
	    return  IDEA_MAC_GENERAL;
	}
	public void setIDEA_MAC_GENERAL (boolean iIDEA_MAC_GENERAL) {
	    IDEA_MAC_GENERAL = iIDEA_MAC_GENERAL;
	}

	public boolean isJUNIPER_CBC128 () {
	    return  JUNIPER_CBC128;
	}
	public void setJUNIPER_CBC128 (boolean iJUNIPER_CBC128) {
	    JUNIPER_CBC128 = iJUNIPER_CBC128;
	}

	public boolean isJUNIPER_COUNTER () {
	    return  JUNIPER_COUNTER;
	}
	public void setJUNIPER_COUNTER (boolean iJUNIPER_COUNTER) {
	    JUNIPER_COUNTER = iJUNIPER_COUNTER;
	}

	public boolean isJUNIPER_ECB128 () {
	    return  JUNIPER_ECB128;
	}
	public void setJUNIPER_ECB128 (boolean iJUNIPER_ECB128) {
	    JUNIPER_ECB128 = iJUNIPER_ECB128;
	}

	public boolean isJUNIPER_KEY_GEN () {
	    return  JUNIPER_KEY_GEN;
	}
	public void setJUNIPER_KEY_GEN (boolean iJUNIPER_KEY_GEN) {
	    JUNIPER_KEY_GEN = iJUNIPER_KEY_GEN;
	}

	public boolean isJUNIPER_SHUFFLE () {
	    return  JUNIPER_SHUFFLE;
	}
	public void setJUNIPER_SHUFFLE (boolean iJUNIPER_SHUFFLE) {
	    JUNIPER_SHUFFLE = iJUNIPER_SHUFFLE;
	}

	public boolean isJUNIPER_WRAP () {
	    return  JUNIPER_WRAP;
	}
	public void setJUNIPER_WRAP (boolean iJUNIPER_WRAP) {
	    JUNIPER_WRAP = iJUNIPER_WRAP;
	}

	public boolean isKEA_KEY_DERIVE () {
	    return  KEA_KEY_DERIVE;
	}
	public void setKEA_KEY_DERIVE (boolean iKEA_KEY_DERIVE) {
	    KEA_KEY_DERIVE = iKEA_KEY_DERIVE;
	}

	public boolean isKEA_KEY_PAIR_GEN () {
	    return  KEA_KEY_PAIR_GEN;
	}
	public void setKEA_KEY_PAIR_GEN (boolean iKEA_KEY_PAIR_GEN) {
	    KEA_KEY_PAIR_GEN = iKEA_KEY_PAIR_GEN;
	}

	public boolean isKEY_WRAP_LYNKS () {
	    return  KEY_WRAP_LYNKS;
	}
	public void setKEY_WRAP_LYNKS (boolean iKEY_WRAP_LYNKS) {
	    KEY_WRAP_LYNKS = iKEY_WRAP_LYNKS;
	}

	public boolean isKEY_WRAP_SET_OAEP () {
	    return  KEY_WRAP_SET_OAEP;
	}
	public void setKEY_WRAP_SET_OAEP (boolean iKEY_WRAP_SET_OAEP) {
	    KEY_WRAP_SET_OAEP = iKEY_WRAP_SET_OAEP;
	}

	public boolean isMD2 () {
	    return  MD2;
	}
	public void setMD2 (boolean iMD2) {
	    MD2 = iMD2;
	}

	public boolean isMD2_HMAC () {
	    return  MD2_HMAC;
	}
	public void setMD2_HMAC (boolean iMD2_HMAC) {
	    MD2_HMAC = iMD2_HMAC;
	}

	public boolean isMD2_HMAC_GENERAL () {
	    return  MD2_HMAC_GENERAL;
	}
	public void setMD2_HMAC_GENERAL (boolean iMD2_HMAC_GENERAL) {
	    MD2_HMAC_GENERAL = iMD2_HMAC_GENERAL;
	}

	public boolean isMD2_KEY_DERIVATION () {
	    return  MD2_KEY_DERIVATION;
	}
	public void setMD2_KEY_DERIVATION (boolean iMD2_KEY_DERIVATION) {
	    MD2_KEY_DERIVATION = iMD2_KEY_DERIVATION;
	}

	public boolean isMD2_RSA_PKCS () {
	    return  MD2_RSA_PKCS;
	}
	public void setMD2_RSA_PKCS (boolean iMD2_RSA_PKCS) {
	    MD2_RSA_PKCS = iMD2_RSA_PKCS;
	}

	public boolean isMD5 () {
	    return  MD5;
	}
	public void setMD5 (boolean iMD5) {
	    MD5 = iMD5;
	}

	public boolean isMD5_HMAC () {
	    return  MD5_HMAC;
	}
	public void setMD5_HMAC (boolean iMD5_HMAC) {
	    MD5_HMAC = iMD5_HMAC;
	}

	public boolean isMD5_HMAC_GENERAL () {
	    return  MD5_HMAC_GENERAL;
	}
	public void setMD5_HMAC_GENERAL (boolean iMD5_HMAC_GENERAL) {
	    MD5_HMAC_GENERAL = iMD5_HMAC_GENERAL;
	}

	public boolean isMD5_KEY_DERIVATION () {
	    return  MD5_KEY_DERIVATION;
	}
	public void setMD5_KEY_DERIVATION (boolean iMD5_KEY_DERIVATION) {
	    MD5_KEY_DERIVATION = iMD5_KEY_DERIVATION;
	}

	public boolean isMD5_RSA_PKCS () {
	    return  MD5_RSA_PKCS;
	}
	public void setMD5_RSA_PKCS (boolean iMD5_RSA_PKCS) {
	    MD5_RSA_PKCS = iMD5_RSA_PKCS;
	}

	public boolean isPBA_SHA1_WITH_SHA1_HMAC () {
	    return  PBA_SHA1_WITH_SHA1_HMAC;
	}
	public void setPBA_SHA1_WITH_SHA1_HMAC (boolean iPBA_SHA1_WITH_SHA1_HMAC) {
	    PBA_SHA1_WITH_SHA1_HMAC = iPBA_SHA1_WITH_SHA1_HMAC;
	}

	public boolean isPBE_MD2_DES_CBC () {
	    return  PBE_MD2_DES_CBC;
	}
	public void setPBE_MD2_DES_CBC (boolean iPBE_MD2_DES_CBC) {
	    PBE_MD2_DES_CBC = iPBE_MD2_DES_CBC;
	}

	public boolean isPBE_MD5_CAST_CBC () {
	    return  PBE_MD5_CAST_CBC;
	}
	public void setPBE_MD5_CAST_CBC (boolean iPBE_MD5_CAST_CBC) {
	    PBE_MD5_CAST_CBC = iPBE_MD5_CAST_CBC;
	}

	public boolean isPBE_MD5_CAST128_CBC () {
	    return  PBE_MD5_CAST128_CBC;
	}
	public void setPBE_MD5_CAST128_CBC (boolean iPBE_MD5_CAST128_CBC) {
	    PBE_MD5_CAST128_CBC = iPBE_MD5_CAST128_CBC;
	}

	public boolean isPBE_MD5_CAST3_CBC () {
	    return  PBE_MD5_CAST3_CBC;
	}
	public void setPBE_MD5_CAST3_CBC (boolean iPBE_MD5_CAST3_CBC) {
	    PBE_MD5_CAST3_CBC = iPBE_MD5_CAST3_CBC;
	}

	public boolean isPBE_MD5_CAST5_CBC () {
	    return  PBE_MD5_CAST5_CBC;
	}
	public void setPBE_MD5_CAST5_CBC (boolean iPBE_MD5_CAST5_CBC) {
	    PBE_MD5_CAST5_CBC = iPBE_MD5_CAST5_CBC;
	}

	public boolean isPBE_MD5_DES_CBC () {
	    return  PBE_MD5_DES_CBC;
	}
	public void setPBE_MD5_DES_CBC (boolean iPBE_MD5_DES_CBC) {
	    PBE_MD5_DES_CBC = iPBE_MD5_DES_CBC;
	}

	public boolean isPBE_SHA1_CAST128_CBC () {
	    return  PBE_SHA1_CAST128_CBC;
	}
	public void setPBE_SHA1_CAST128_CBC (boolean iPBE_SHA1_CAST128_CBC) {
	    PBE_SHA1_CAST128_CBC = iPBE_SHA1_CAST128_CBC;
	}

	public boolean isPBE_SHA1_CAST5_CBC () {
	    return  PBE_SHA1_CAST5_CBC;
	}
	public void setPBE_SHA1_CAST5_CBC (boolean iPBE_SHA1_CAST5_CBC) {
	    PBE_SHA1_CAST5_CBC = iPBE_SHA1_CAST5_CBC;
	}

	public boolean isPBE_SHA1_DES2_EDE_CBC () {
	    return  PBE_SHA1_DES2_EDE_CBC;
	}
	public void setPBE_SHA1_DES2_EDE_CBC (boolean iPBE_SHA1_DES2_EDE_CBC) {
	    PBE_SHA1_DES2_EDE_CBC = iPBE_SHA1_DES2_EDE_CBC;
	}

	public boolean isPBE_SHA1_DES3_EDE_CBC () {
	    return  PBE_SHA1_DES3_EDE_CBC;
	}
	public void setPBE_SHA1_DES3_EDE_CBC (boolean iPBE_SHA1_DES3_EDE_CBC) {
	    PBE_SHA1_DES3_EDE_CBC = iPBE_SHA1_DES3_EDE_CBC;
	}

	public boolean isPBE_SHA1_RC2_128_CBC () {
	    return  PBE_SHA1_RC2_128_CBC;
	}
	public void setPBE_SHA1_RC2_128_CBC (boolean iPBE_SHA1_RC2_128_CBC) {
	    PBE_SHA1_RC2_128_CBC = iPBE_SHA1_RC2_128_CBC;
	}

	public boolean isPBE_SHA1_RC2_40_CBC () {
	    return  PBE_SHA1_RC2_40_CBC;
	}
	public void setPBE_SHA1_RC2_40_CBC (boolean iPBE_SHA1_RC2_40_CBC) {
	    PBE_SHA1_RC2_40_CBC = iPBE_SHA1_RC2_40_CBC;
	}

	public boolean isPBE_SHA1_RC4_128 () {
	    return  PBE_SHA1_RC4_128;
	}
	public void setPBE_SHA1_RC4_128 (boolean iPBE_SHA1_RC4_128) {
	    PBE_SHA1_RC4_128 = iPBE_SHA1_RC4_128;
	}

	public boolean isPBE_SHA1_RC4_40 () {
	    return  PBE_SHA1_RC4_40;
	}
	public void setPBE_SHA1_RC4_40 (boolean iPBE_SHA1_RC4_40) {
	    PBE_SHA1_RC4_40 = iPBE_SHA1_RC4_40;
	}

	public boolean isPKCS5_PBKD2 () {
	    return  PKCS5_PBKD2;
	}
	public void setPKCS5_PBKD2 (boolean iPKCS5_PBKD2) {
	    PKCS5_PBKD2 = iPKCS5_PBKD2;
	}

	public boolean isRC2_CBC () {
	    return  RC2_CBC;
	}
	public void setRC2_CBC (boolean iRC2_CBC) {
	    RC2_CBC = iRC2_CBC;
	}

	public boolean isRC2_CBC_PAD () {
	    return  RC2_CBC_PAD;
	}
	public void setRC2_CBC_PAD (boolean iRC2_CBC_PAD) {
	    RC2_CBC_PAD = iRC2_CBC_PAD;
	}

	public boolean isRC2_ECB () {
	    return  RC2_ECB;
	}
	public void setRC2_ECB (boolean iRC2_ECB) {
	    RC2_ECB = iRC2_ECB;
	}

	public boolean isRC2_KEY_GEN () {
	    return  RC2_KEY_GEN;
	}
	public void setRC2_KEY_GEN (boolean iRC2_KEY_GEN) {
	    RC2_KEY_GEN = iRC2_KEY_GEN;
	}

	public boolean isRC2_MAC () {
	    return  RC2_MAC;
	}
	public void setRC2_MAC (boolean iRC2_MAC) {
	    RC2_MAC = iRC2_MAC;
	}

	public boolean isRC2_MAC_GENERAL () {
	    return  RC2_MAC_GENERAL;
	}
	public void setRC2_MAC_GENERAL (boolean iRC2_MAC_GENERAL) {
	    RC2_MAC_GENERAL = iRC2_MAC_GENERAL;
	}

	public boolean isRC4 () {
	    return  RC4;
	}
	public void setRC4 (boolean iRC4) {
	    RC4 = iRC4;
	}

	public boolean isRC4_KEY_GEN () {
	    return  RC4_KEY_GEN;
	}
	public void setRC4_KEY_GEN (boolean iRC4_KEY_GEN) {
	    RC4_KEY_GEN = iRC4_KEY_GEN;
	}

	public boolean isRC5_CBC () {
	    return  RC5_CBC;
	}
	public void setRC5_CBC (boolean iRC5_CBC) {
	    RC5_CBC = iRC5_CBC;
	}

	public boolean isRC5_CBC_PAD () {
	    return  RC5_CBC_PAD;
	}
	public void setRC5_CBC_PAD (boolean iRC5_CBC_PAD) {
	    RC5_CBC_PAD = iRC5_CBC_PAD;
	}

	public boolean isRC5_ECB () {
	    return  RC5_ECB;
	}
	public void setRC5_ECB (boolean iRC5_ECB) {
	    RC5_ECB = iRC5_ECB;
	}

	public boolean isRC5_KEY_GEN () {
	    return  RC5_KEY_GEN;
	}
	public void setRC5_KEY_GEN (boolean iRC5_KEY_GEN) {
	    RC5_KEY_GEN = iRC5_KEY_GEN;
	}

	public boolean isRC5_MAC () {
	    return  RC5_MAC;
	}
	public void setRC5_MAC (boolean iRC5_MAC) {
	    RC5_MAC = iRC5_MAC;
	}

	public boolean isRC5_MAC_GENERAL () {
	    return  RC5_MAC_GENERAL;
	}
	public void setRC5_MAC_GENERAL (boolean iRC5_MAC_GENERAL) {
	    RC5_MAC_GENERAL = iRC5_MAC_GENERAL;
	}

	public boolean isRIPEMD128 () {
	    return  RIPEMD128;
	}
	public void setRIPEMD128 (boolean iRIPEMD128) {
	    RIPEMD128 = iRIPEMD128;
	}

	public boolean isRIPEMD128_HMAC () {
	    return  RIPEMD128_HMAC;
	}
	public void setRIPEMD128_HMAC (boolean iRIPEMD128_HMAC) {
	    RIPEMD128_HMAC = iRIPEMD128_HMAC;
	}

	public boolean isRIPEMD128_HMAC_GENERAL () {
	    return  RIPEMD128_HMAC_GENERAL;
	}
	public void setRIPEMD128_HMAC_GENERAL (boolean iRIPEMD128_HMAC_GENERAL) {
	    RIPEMD128_HMAC_GENERAL = iRIPEMD128_HMAC_GENERAL;
	}

	public boolean isRIPEMD128_RSA_PKCS () {
	    return  RIPEMD128_RSA_PKCS;
	}
	public void setRIPEMD128_RSA_PKCS (boolean iRIPEMD128_RSA_PKCS) {
	    RIPEMD128_RSA_PKCS = iRIPEMD128_RSA_PKCS;
	}

	public boolean isRIPEMD160 () {
	    return  RIPEMD160;
	}
	public void setRIPEMD160 (boolean iRIPEMD160) {
	    RIPEMD160 = iRIPEMD160;
	}

	public boolean isRIPEMD160_HMAC () {
	    return  RIPEMD160_HMAC;
	}
	public void setRIPEMD160_HMAC (boolean iRIPEMD160_HMAC) {
	    RIPEMD160_HMAC = iRIPEMD160_HMAC;
	}

	public boolean isRIPEMD160_HMAC_GENERAL () {
	    return  RIPEMD160_HMAC_GENERAL;
	}
	public void setRIPEMD160_HMAC_GENERAL (boolean iRIPEMD160_HMAC_GENERAL) {
	    RIPEMD160_HMAC_GENERAL = iRIPEMD160_HMAC_GENERAL;
	}

	public boolean isRIPEMD160_RSA_PKCS () {
	    return  RIPEMD160_RSA_PKCS;
	}
	public void setRIPEMD160_RSA_PKCS (boolean iRIPEMD160_RSA_PKCS) {
	    RIPEMD160_RSA_PKCS = iRIPEMD160_RSA_PKCS;
	}

	public boolean isRSA_9796 () {
	    return  RSA_9796;
	}
	public void setRSA_9796 (boolean iRSA_9796) {
	    RSA_9796 = iRSA_9796;
	}

	public boolean isRSA_PKCS () {
	    return  RSA_PKCS;
	}
	public void setRSA_PKCS (boolean iRSA_PKCS) {
	    RSA_PKCS = iRSA_PKCS;
	}

	public boolean isRSA_PKCS_KEY_PAIR_GEN () {
	    return  RSA_PKCS_KEY_PAIR_GEN;
	}
	public void setRSA_PKCS_KEY_PAIR_GEN (boolean iRSA_PKCS_KEY_PAIR_GEN) {
	    RSA_PKCS_KEY_PAIR_GEN = iRSA_PKCS_KEY_PAIR_GEN;
	}

	public boolean isRSA_PKCS_OAEP () {
	    return  RSA_PKCS_OAEP;
	}
	public void setRSA_PKCS_OAEP (boolean iRSA_PKCS_OAEP) {
	    RSA_PKCS_OAEP = iRSA_PKCS_OAEP;
	}

	public boolean isRSA_PKCS_PSS () {
	    return  RSA_PKCS_PSS;
	}
	public void setRSA_PKCS_PSS (boolean iRSA_PKCS_PSS) {
	    RSA_PKCS_PSS = iRSA_PKCS_PSS;
	}

	public boolean isRSA_X_509 () {
	    return  RSA_X_509;
	}
	public void setRSA_X_509 (boolean iRSA_X_509) {
	    RSA_X_509 = iRSA_X_509;
	}

	public boolean isRSA_X9_31 () {
	    return  RSA_X9_31;
	}
	public void setRSA_X9_31 (boolean iRSA_X9_31) {
	    RSA_X9_31 = iRSA_X9_31;
	}

	public boolean isRSA_X9_31_KEY_PAIR_GEN () {
	    return  RSA_X9_31_KEY_PAIR_GEN;
	}
	public void setRSA_X9_31_KEY_PAIR_GEN (boolean iRSA_X9_31_KEY_PAIR_GEN) {
	    RSA_X9_31_KEY_PAIR_GEN = iRSA_X9_31_KEY_PAIR_GEN;
	}

	public boolean isSHA_1 () {
	    return  SHA_1;
	}
	public void setSHA_1 (boolean iSHA_1) {
	    SHA_1 = iSHA_1;
	}

	public boolean isSHA_1_HMAC () {
	    return  SHA_1_HMAC;
	}
	public void setSHA_1_HMAC (boolean iSHA_1_HMAC) {
	    SHA_1_HMAC = iSHA_1_HMAC;
	}

	public boolean isSHA_1_HMAC_GENERAL () {
	    return  SHA_1_HMAC_GENERAL;
	}
	public void setSHA_1_HMAC_GENERAL (boolean iSHA_1_HMAC_GENERAL) {
	    SHA_1_HMAC_GENERAL = iSHA_1_HMAC_GENERAL;
	}

	public boolean isSHA1_KEY_DERIVATION () {
	    return  SHA1_KEY_DERIVATION;
	}
	public void setSHA1_KEY_DERIVATION (boolean iSHA1_KEY_DERIVATION) {
	    SHA1_KEY_DERIVATION = iSHA1_KEY_DERIVATION;
	}

	public boolean isSHA1_RSA_PKCS () {
	    return  SHA1_RSA_PKCS;
	}
	public void setSHA1_RSA_PKCS (boolean iSHA1_RSA_PKCS) {
	    SHA1_RSA_PKCS = iSHA1_RSA_PKCS;
	}

	public boolean isSHA1_RSA_PKCS_PSS () {
	    return  SHA1_RSA_PKCS_PSS;
	}
	public void setSHA1_RSA_PKCS_PSS (boolean iSHA1_RSA_PKCS_PSS) {
	    SHA1_RSA_PKCS_PSS = iSHA1_RSA_PKCS_PSS;
	}

	public boolean isSHA1_RSA_X9_31 () {
	    return  SHA1_RSA_X9_31;
	}
	public void setSHA1_RSA_X9_31 (boolean iSHA1_RSA_X9_31) {
	    SHA1_RSA_X9_31 = iSHA1_RSA_X9_31;
	}

	public boolean isSHA256 () {
	    return  SHA256;
	}
	public void setSHA256 (boolean iSHA256) {
	    SHA256 = iSHA256;
	}

	public boolean isSHA256_HMAC () {
	    return  SHA256_HMAC;
	}
	public void setSHA256_HMAC (boolean iSHA256_HMAC) {
	    SHA256_HMAC = iSHA256_HMAC;
	}

	public boolean isSHA256_HMAC_GENERAL () {
	    return  SHA256_HMAC_GENERAL;
	}
	public void setSHA256_HMAC_GENERAL (boolean iSHA256_HMAC_GENERAL) {
	    SHA256_HMAC_GENERAL = iSHA256_HMAC_GENERAL;
	}

	public boolean isSHA256_KEY_DERIVATION () {
	    return  SHA256_KEY_DERIVATION;
	}
	public void setSHA256_KEY_DERIVATION (boolean iSHA256_KEY_DERIVATION) {
	    SHA256_KEY_DERIVATION = iSHA256_KEY_DERIVATION;
	}

	public boolean isSHA256_RSA_PKCS () {
	    return  SHA256_RSA_PKCS;
	}
	public void setSHA256_RSA_PKCS (boolean iSHA256_RSA_PKCS) {
	    SHA256_RSA_PKCS = iSHA256_RSA_PKCS;
	}

	public boolean isSHA256_RSA_PKCS_PSS () {
	    return  SHA256_RSA_PKCS_PSS;
	}
	public void setSHA256_RSA_PKCS_PSS (boolean iSHA256_RSA_PKCS_PSS) {
	    SHA256_RSA_PKCS_PSS = iSHA256_RSA_PKCS_PSS;
	}

	public boolean isSHA384 () {
	    return  SHA384;
	}
	public void setSHA384 (boolean iSHA384) {
	    SHA384 = iSHA384;
	}

	public boolean isSHA384_HMAC () {
	    return  SHA384_HMAC;
	}
	public void setSHA384_HMAC (boolean iSHA384_HMAC) {
	    SHA384_HMAC = iSHA384_HMAC;
	}

	public boolean isSHA384_HMAC_GENERAL () {
	    return  SHA384_HMAC_GENERAL;
	}
	public void setSHA384_HMAC_GENERAL (boolean iSHA384_HMAC_GENERAL) {
	    SHA384_HMAC_GENERAL = iSHA384_HMAC_GENERAL;
	}

	public boolean isSHA384_KEY_DERIVATION () {
	    return  SHA384_KEY_DERIVATION;
	}
	public void setSHA384_KEY_DERIVATION (boolean iSHA384_KEY_DERIVATION) {
	    SHA384_KEY_DERIVATION = iSHA384_KEY_DERIVATION;
	}

	public boolean isSHA384_RSA_PKCS () {
	    return  SHA384_RSA_PKCS;
	}
	public void setSHA384_RSA_PKCS (boolean iSHA384_RSA_PKCS) {
	    SHA384_RSA_PKCS = iSHA384_RSA_PKCS;
	}

	public boolean isSHA384_RSA_PKCS_PSS () {
	    return  SHA384_RSA_PKCS_PSS;
	}
	public void setSHA384_RSA_PKCS_PSS (boolean iSHA384_RSA_PKCS_PSS) {
	    SHA384_RSA_PKCS_PSS = iSHA384_RSA_PKCS_PSS;
	}

	public boolean isSHA512 () {
	    return  SHA512;
	}
	public void setSHA512 (boolean iSHA512) {
	    SHA512 = iSHA512;
	}

	public boolean isSHA512_HMAC () {
	    return  SHA512_HMAC;
	}
	public void setSHA512_HMAC (boolean iSHA512_HMAC) {
	    SHA512_HMAC = iSHA512_HMAC;
	}

	public boolean isSHA512_HMAC_GENERAL () {
	    return  SHA512_HMAC_GENERAL;
	}
	public void setSHA512_HMAC_GENERAL (boolean iSHA512_HMAC_GENERAL) {
	    SHA512_HMAC_GENERAL = iSHA512_HMAC_GENERAL;
	}

	public boolean isSHA512_KEY_DERIVATION () {
	    return  SHA512_KEY_DERIVATION;
	}
	public void setSHA512_KEY_DERIVATION (boolean iSHA512_KEY_DERIVATION) {
	    SHA512_KEY_DERIVATION = iSHA512_KEY_DERIVATION;
	}

	public boolean isSHA512_RSA_PKCS () {
	    return  SHA512_RSA_PKCS;
	}
	public void setSHA512_RSA_PKCS (boolean iSHA512_RSA_PKCS) {
	    SHA512_RSA_PKCS = iSHA512_RSA_PKCS;
	}

	public boolean isSHA512_RSA_PKCS_PSS () {
	    return  SHA512_RSA_PKCS_PSS;
	}
	public void setSHA512_RSA_PKCS_PSS (boolean iSHA512_RSA_PKCS_PSS) {
	    SHA512_RSA_PKCS_PSS = iSHA512_RSA_PKCS_PSS;
	}

	public boolean isSKIPJACK_CBC64 () {
	    return  SKIPJACK_CBC64;
	}
	public void setSKIPJACK_CBC64 (boolean iSKIPJACK_CBC64) {
	    SKIPJACK_CBC64 = iSKIPJACK_CBC64;
	}

	public boolean isSKIPJACK_CFB16 () {
	    return  SKIPJACK_CFB16;
	}
	public void setSKIPJACK_CFB16 (boolean iSKIPJACK_CFB16) {
	    SKIPJACK_CFB16 = iSKIPJACK_CFB16;
	}

	public boolean isSKIPJACK_CFB32 () {
	    return  SKIPJACK_CFB32;
	}
	public void setSKIPJACK_CFB32 (boolean iSKIPJACK_CFB32) {
	    SKIPJACK_CFB32 = iSKIPJACK_CFB32;
	}

	public boolean isSKIPJACK_CFB64 () {
	    return  SKIPJACK_CFB64;
	}
	public void setSKIPJACK_CFB64 (boolean iSKIPJACK_CFB64) {
	    SKIPJACK_CFB64 = iSKIPJACK_CFB64;
	}

	public boolean isSKIPJACK_CFB8 () {
	    return  SKIPJACK_CFB8;
	}
	public void setSKIPJACK_CFB8 (boolean iSKIPJACK_CFB8) {
	    SKIPJACK_CFB8 = iSKIPJACK_CFB8;
	}

	public boolean isSKIPJACK_ECB64 () {
	    return  SKIPJACK_ECB64;
	}
	public void setSKIPJACK_ECB64 (boolean iSKIPJACK_ECB64) {
	    SKIPJACK_ECB64 = iSKIPJACK_ECB64;
	}

	public boolean isSKIPJACK_KEY_GEN () {
	    return  SKIPJACK_KEY_GEN;
	}
	public void setSKIPJACK_KEY_GEN (boolean iSKIPJACK_KEY_GEN) {
	    SKIPJACK_KEY_GEN = iSKIPJACK_KEY_GEN;
	}

	public boolean isSKIPJACK_OFB64 () {
	    return  SKIPJACK_OFB64;
	}
	public void setSKIPJACK_OFB64 (boolean iSKIPJACK_OFB64) {
	    SKIPJACK_OFB64 = iSKIPJACK_OFB64;
	}

	public boolean isSKIPJACK_PRIVATE_WRAP () {
	    return  SKIPJACK_PRIVATE_WRAP;
	}
	public void setSKIPJACK_PRIVATE_WRAP (boolean iSKIPJACK_PRIVATE_WRAP) {
	    SKIPJACK_PRIVATE_WRAP = iSKIPJACK_PRIVATE_WRAP;
	}

	public boolean isSKIPJACK_RELAYX () {
	    return  SKIPJACK_RELAYX;
	}
	public void setSKIPJACK_RELAYX (boolean iSKIPJACK_RELAYX) {
	    SKIPJACK_RELAYX = iSKIPJACK_RELAYX;
	}

	public boolean isSKIPJACK_WRAP () {
	    return  SKIPJACK_WRAP;
	}
	public void setSKIPJACK_WRAP (boolean iSKIPJACK_WRAP) {
	    SKIPJACK_WRAP = iSKIPJACK_WRAP;
	}

	public boolean isSSL3_KEY_AND_MAC_DERIVE () {
	    return  SSL3_KEY_AND_MAC_DERIVE;
	}
	public void setSSL3_KEY_AND_MAC_DERIVE (boolean iSSL3_KEY_AND_MAC_DERIVE) {
	    SSL3_KEY_AND_MAC_DERIVE = iSSL3_KEY_AND_MAC_DERIVE;
	}

	public boolean isSSL3_MASTER_KEY_DERIVE () {
	    return  SSL3_MASTER_KEY_DERIVE;
	}
	public void setSSL3_MASTER_KEY_DERIVE (boolean iSSL3_MASTER_KEY_DERIVE) {
	    SSL3_MASTER_KEY_DERIVE = iSSL3_MASTER_KEY_DERIVE;
	}

	public boolean isSSL3_MASTER_KEY_DERIVE_DH () {
	    return  SSL3_MASTER_KEY_DERIVE_DH;
	}
	public void setSSL3_MASTER_KEY_DERIVE_DH (boolean iSSL3_MASTER_KEY_DERIVE_DH) {
	    SSL3_MASTER_KEY_DERIVE_DH = iSSL3_MASTER_KEY_DERIVE_DH;
	}

	public boolean isSSL3_MD5_MAC () {
	    return  SSL3_MD5_MAC;
	}
	public void setSSL3_MD5_MAC (boolean iSSL3_MD5_MAC) {
	    SSL3_MD5_MAC = iSSL3_MD5_MAC;
	}

	public boolean isSSL3_PRE_MASTER_KEY_GEN () {
	    return  SSL3_PRE_MASTER_KEY_GEN;
	}
	public void setSSL3_PRE_MASTER_KEY_GEN (boolean iSSL3_PRE_MASTER_KEY_GEN) {
	    SSL3_PRE_MASTER_KEY_GEN = iSSL3_PRE_MASTER_KEY_GEN;
	}

	public boolean isSSL3_SHA1_MAC () {
	    return  SSL3_SHA1_MAC;
	}
	public void setSSL3_SHA1_MAC (boolean iSSL3_SHA1_MAC) {
	    SSL3_SHA1_MAC = iSSL3_SHA1_MAC;
	}

	public boolean isTLS_KEY_AND_MAC_DERIVE () {
	    return  TLS_KEY_AND_MAC_DERIVE;
	}
	public void setTLS_KEY_AND_MAC_DERIVE (boolean iTLS_KEY_AND_MAC_DERIVE) {
	    TLS_KEY_AND_MAC_DERIVE = iTLS_KEY_AND_MAC_DERIVE;
	}

	public boolean isTLS_MASTER_KEY_DERIVE () {
	    return  TLS_MASTER_KEY_DERIVE;
	}
	public void setTLS_MASTER_KEY_DERIVE (boolean iTLS_MASTER_KEY_DERIVE) {
	    TLS_MASTER_KEY_DERIVE = iTLS_MASTER_KEY_DERIVE;
	}

	public boolean isTLS_MASTER_KEY_DERIVE_DH () {
	    return  TLS_MASTER_KEY_DERIVE_DH;
	}
	public void setTLS_MASTER_KEY_DERIVE_DH (boolean iTLS_MASTER_KEY_DERIVE_DH) {
	    TLS_MASTER_KEY_DERIVE_DH = iTLS_MASTER_KEY_DERIVE_DH;
	}

	public boolean isTLS_PRE_MASTER_KEY_GEN () {
	    return  TLS_PRE_MASTER_KEY_GEN;
	}
	public void setTLS_PRE_MASTER_KEY_GEN (boolean iTLS_PRE_MASTER_KEY_GEN) {
	    TLS_PRE_MASTER_KEY_GEN = iTLS_PRE_MASTER_KEY_GEN;
	}

	public boolean isTLS_PRF () {
	    return  TLS_PRF;
	}
	public void setTLS_PRF (boolean iTLS_PRF) {
	    TLS_PRF = iTLS_PRF;
	}

	public boolean isVENDOR_DEFINED () {
	    return  VENDOR_DEFINED;
	}
	public void setVENDOR_DEFINED (boolean iVENDOR_DEFINED) {
	    VENDOR_DEFINED = iVENDOR_DEFINED;
	}

	public boolean isWTLS_CLIENT_KEY_AND_MAC_DERIVE () {
	    return  WTLS_CLIENT_KEY_AND_MAC_DERIVE;
	}
	public void setWTLS_CLIENT_KEY_AND_MAC_DERIVE (boolean iWTLS_CLIENT_KEY_AND_MAC_DERIVE) {
	    WTLS_CLIENT_KEY_AND_MAC_DERIVE = iWTLS_CLIENT_KEY_AND_MAC_DERIVE;
	}

	public boolean isWTLS_MASTER_KEY_DERIVE () {
	    return  WTLS_MASTER_KEY_DERIVE;
	}
	public void setWTLS_MASTER_KEY_DERIVE (boolean iWTLS_MASTER_KEY_DERIVE) {
	    WTLS_MASTER_KEY_DERIVE = iWTLS_MASTER_KEY_DERIVE;
	}

	public boolean isWTLS_MASTER_KEY_DERIVE_DH_ECC () {
	    return  WTLS_MASTER_KEY_DERIVE_DH_ECC;
	}
	public void setWTLS_MASTER_KEY_DERIVE_DH_ECC (boolean iWTLS_MASTER_KEY_DERIVE_DH_ECC) {
	    WTLS_MASTER_KEY_DERIVE_DH_ECC = iWTLS_MASTER_KEY_DERIVE_DH_ECC;
	}

	public boolean isWTLS_PRE_MASTER_KEY_GEN () {
	    return  WTLS_PRE_MASTER_KEY_GEN;
	}
	public void setWTLS_PRE_MASTER_KEY_GEN (boolean iWTLS_PRE_MASTER_KEY_GEN) {
	    WTLS_PRE_MASTER_KEY_GEN = iWTLS_PRE_MASTER_KEY_GEN;
	}

	public boolean isWTLS_PRF () {
	    return  WTLS_PRF;
	}
	public void setWTLS_PRF (boolean iWTLS_PRF) {
	    WTLS_PRF = iWTLS_PRF;
	}

	public boolean isWTLS_SERVER_KEY_AND_MAC_DERIVE () {
	    return  WTLS_SERVER_KEY_AND_MAC_DERIVE;
	}
	public void setWTLS_SERVER_KEY_AND_MAC_DERIVE (boolean iWTLS_SERVER_KEY_AND_MAC_DERIVE) {
	    WTLS_SERVER_KEY_AND_MAC_DERIVE = iWTLS_SERVER_KEY_AND_MAC_DERIVE;
	}

	public boolean isX9_42_DH_DERIVE () {
	    return  X9_42_DH_DERIVE;
	}
	public void setX9_42_DH_DERIVE (boolean iX9_42_DH_DERIVE) {
	    X9_42_DH_DERIVE = iX9_42_DH_DERIVE;
	}

	public boolean isX9_42_DH_HYBRID_DERIVE () {
	    return  X9_42_DH_HYBRID_DERIVE;
	}
	public void setX9_42_DH_HYBRID_DERIVE (boolean iX9_42_DH_HYBRID_DERIVE) {
	    X9_42_DH_HYBRID_DERIVE = iX9_42_DH_HYBRID_DERIVE;
	}

	public boolean isX9_42_DH_KEY_PAIR_GEN () {
	    return  X9_42_DH_KEY_PAIR_GEN;
	}
	public void setX9_42_DH_KEY_PAIR_GEN (boolean iX9_42_DH_KEY_PAIR_GEN) {
	    X9_42_DH_KEY_PAIR_GEN = iX9_42_DH_KEY_PAIR_GEN;
	}

	public boolean isX9_42_DH_PARAMETER_GEN () {
	    return  X9_42_DH_PARAMETER_GEN;
	}
	public void setX9_42_DH_PARAMETER_GEN (boolean iX9_42_DH_PARAMETER_GEN) {
	    X9_42_DH_PARAMETER_GEN = iX9_42_DH_PARAMETER_GEN;
	}

	public boolean isX9_42_MQV_DERIVE () {
	    return  X9_42_MQV_DERIVE;
	}
	public void setX9_42_MQV_DERIVE (boolean iX9_42_MQV_DERIVE) {
	    X9_42_MQV_DERIVE = iX9_42_MQV_DERIVE;
	}

	public boolean isXOR_BASE_AND_DATA () {
	    return  XOR_BASE_AND_DATA;
	}
	public void setXOR_BASE_AND_DATA (boolean iXOR_BASE_AND_DATA) {
	    XOR_BASE_AND_DATA = iXOR_BASE_AND_DATA;
	}

}
