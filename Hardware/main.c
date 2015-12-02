#include <msp430.h>

#define LED1	BIT0
#define LED2	BIT6

#define RX		BIT1
#define TX		BIT2

/*
 * DO NOT MODIFY
 */
void _init() {
	WDTCTL = WDTPW | WDTHOLD;	// Stop watchdog timer

	//Configure CPU clock
	if (CALBC1_1MHZ == 0xFF) {
		while (1)
			;
	}

	DCOCTL = 0;
	BCSCTL1 = CALBC1_1MHZ;
	DCOCTL = CALDCO_1MHZ;
}

void _init_UART() {

	P1SEL |= RX + TX;
	P1SEL2 |= RX + TX;

	UCA0CTL1 |= UCSSEL_2;

	UCA0BR0 = 104;
	UCA0BR1 = 0;
	UCA0MCTL = UCBRS0;
	UCA0CTL1 &= ~UCSWRST;

	//Enable RX interupt
	IE2 |= UCA0RXIE;
}

int main(void) {
	_init();
	_init_UART();

	P1DIR |= LED1 + LED2;
	P1OUT &= ~(LED1 + LED2);

	__enable_interrupt();
	// For some reason msp430-gcc gives this
	// main.c:50:2: error: void value not ignored as it ought to be
	// __bis_SR_register(LPM0 | GIE);

}

#pragma vector=USCIAB0RX_VECTOR
__interrupt void USCI0RX_ISR(void) {
	while (!(IFG2&UCA0TXIFG));
	UCA0TXBUF = UCA0RXBUF;
	if (UCA0RXBUF == 0) {
		P1OUT &= ~(LED1 + LED2);
	} else {
		P1OUT ^= LED1 + LED2;
	}
}
