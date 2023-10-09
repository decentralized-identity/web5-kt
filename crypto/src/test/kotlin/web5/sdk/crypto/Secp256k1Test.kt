package web5.sdk.crypto

import com.nimbusds.jose.JWSAlgorithm
import com.nimbusds.jose.jwk.KeyType
import com.nimbusds.jose.jwk.KeyUse
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class Secp256k1Test {
  @Test
  fun `test key generation`() {
    val privateKey = Secp256k1.generatePrivateKey()

    Secp256k1.validateKey(privateKey)
    assertEquals(JWSAlgorithm.ES256K, privateKey.algorithm)
    assertEquals(KeyUse.SIGNATURE, privateKey.keyUse)
    assertNotNull(privateKey.keyID)
    assertEquals(KeyType.EC, privateKey.keyType)
    assertTrue(privateKey.isPrivate)
  }

  @Test
  fun `test public key`() {
    val privateKey = Secp256k1.generatePrivateKey()

    val publicKey = Secp256k1.computePublicKey(privateKey)

    Secp256k1.validateKey(publicKey)
    assertEquals(publicKey.keyID, privateKey.keyID)
    assertEquals(JWSAlgorithm.ES256K, publicKey.algorithm)
    assertEquals(KeyUse.SIGNATURE, publicKey.keyUse)
    assertEquals(KeyType.EC, publicKey.keyType)
    assertFalse(publicKey.isPrivate)
  }
}