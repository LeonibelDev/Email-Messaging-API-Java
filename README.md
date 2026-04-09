# Email Messaging API

## Description
A robust REST API built with Spring Boot for sending customizable emails. This service provides a streamlined endpoint to dispatch formatted emails via an SMTP server. It accepts a JSON payload to populate a predefined HTML email template with custom text, images, and actionable buttons.

## Prerequisites
Ensure that you update the `src/main/resources/application.properties` file with your valid SMTP credentials before running the application:

```properties
email=your-email@example.com
password=your-application-password
```

## API Endpoint Reference

### Send Email

**Endpoint Route:**
`POST /api/emails/send`

**Local URL Example:**
`http://localhost:8080/api/emails/send`

**Description:**
Initiates the sending of an email to the specified recipient using the provided application credentials and template variables.

### Request Body (JSON)

The endpoint expects an `application/json` payload containing the following fields:

* `recipient` (string): The email address of the person receiving the email.
* `subject` (string): The subject line of the email.
* `body` (string): The main text content to display within the email structure.
* `url` (string): A destination link for the call-to-action button within the email template.
* `buttonText` (string): The text to display on the call-to-action button.
* `imageUrl` (string): A direct link to an image to embed within the email template.

**Example Request:**

```json
{
  "recipient": "user@example.com",
  "subject": "Welcome to Our Platform",
  "body": "Thank you for joining us. We are excited to have you here. Please click the button below to get started.",
  "url": "https://example.com/login",
  "buttonText": "Login to your account",
  "imageUrl": "https://example.com/assets/welcome-banner.png"
}
```

### Response

**Success Response (HTTP 200 OK):**
```json
{
  "message": "Email sent successfully",
  "emailData": {
    "recipient": "user@example.com",
    "subject": "Welcome to Our Platform",
    "body": "Thank you for joining us. We are excited to have you here. Please click the button below to get started.",
    "url": "https://example.com/login",
    "buttonText": "Login to your account",
    "imageUrl": "https://example.com/assets/welcome-banner.png"
  }
}
```

**Error Response (HTTP 500 Internal Server Error):**
Returns a plain text error message detail explaining why the email could not be delivered.
